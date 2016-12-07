package com.zjut.task;

import java.util.List;
import java.util.LinkedList;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("processor")
public class Server extends HttpServlet {

	private static final long serialVersionUID = -3079101309407279945L;
	private Logger logger = Logger.getLogger(Server.class);
	private static List<SelectionKey> wpool = new LinkedList<SelectionKey>();
	private static Selector selector;
	private ServerSocketChannel sschannel;
	private InetSocketAddress address;
	protected Notifier notifier;
	private int port;
	private volatile boolean stop = false;

	private static int MAX_THREADS = 4;

	public Server() {

	}

	@Override
	public void init() throws ServletException {
		super.init();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				new Server(8888).runTask();
			}
		};
		new Thread(task).start();
	}

	public Server(int port) {
		try {
			this.port = port;
			LogHandler loger = new LogHandler();
			TimeHandler timer = new TimeHandler();
			ServerHandler serverHandler = new ServerHandler();
			notifier = Notifier.getNotifier();
			notifier.addListener(loger);
			notifier.addListener(timer);
			notifier.addListener(serverHandler);
			notifier = Notifier.getNotifier();
			logger.info("Server starting ...");
			for (int i = 0; i < MAX_THREADS; i++) {
				Thread r = new Reader();
				Thread w = new Writer();
				r.start();
				w.start();
			}
			selector = Selector.open();
			sschannel = ServerSocketChannel.open();
			sschannel.configureBlocking(false);
			address = new InetSocketAddress(port);
			ServerSocket ss = sschannel.socket();
			ss.bind(address);
			sschannel.register(selector, SelectionKey.OP_ACCEPT);
			logger.info("server init success...");
		} catch (Exception e) {
			logger.info("server init failed...");
		} finally {
			logger.info("server closed ....");
			try {
				if (sschannel != null)
					sschannel.close();
			} catch (IOException e) {
				logger.info("server close failed...");
			}
			sschannel = null;
		}
	}

	public void runTask() {
		logger.info("Server started ...");
		logger.info("Server listening on port: " + this.port);
		while (!stop) {
			try {
				int num = 0;
				num = selector.select();
				if (num > 0) {
					Set<SelectionKey> selectedKeys = selector.selectedKeys();
					Iterator<SelectionKey> it = selectedKeys.iterator();
					while (it.hasNext()) {
						SelectionKey key = (SelectionKey) it.next();
						it.remove();
						if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
							ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
							notifier.fireOnAccept();
							SocketChannel sc = ssc.accept();
							sc.configureBlocking(false);
							Request request = new Request(sc);
							notifier.fireOnAccepted(request);
							sc.register(selector, SelectionKey.OP_READ, request);
						} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
							Reader.processRequest(key);
							key.cancel();
						} else if ((key.readyOps() & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE) {
							Writer.processRequest(key);
							key.cancel();
						}
					}
				} else {
					addRegister();
				}
			} catch (Exception e) {
				notifier.fireOnError("Error occured in Server: " + e.getMessage());
				continue;
			}
		}
	}

	private void addRegister() {
		synchronized (wpool) {
			while (!wpool.isEmpty()) {
				SelectionKey key = (SelectionKey) wpool.remove(0);
				SocketChannel schannel = (SocketChannel) key.channel();
				try {
					schannel.register(selector, SelectionKey.OP_WRITE, key.attachment());
				} catch (Exception e) {
					try {
						schannel.finishConnect();
						schannel.close();
						schannel.socket().close();
						notifier.fireOnClosed((Request) key.attachment());
					} catch (Exception e1) {
					}
					notifier.fireOnError("Error occured in addRegister: " + e.getMessage());
				}
			}
		}
	}

	public static void processWriteRequest(SelectionKey key) {
		synchronized (wpool) {
			wpool.add(wpool.size(), key);
			wpool.notifyAll();
		}
		selector.wakeup();
	}

	public void stopServer() {
		this.stop = true;
	}
}
