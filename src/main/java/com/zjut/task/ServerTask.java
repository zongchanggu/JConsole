package com.zjut.task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("processor")
public class ServerTask extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8697310485730902324L;
	private Logger logger = Logger.getLogger(ServerSocket.class);
	private ExecutorService threadPool = Executors.newCachedThreadPool();

	private int port = 0;
	private Selector selector;
	private ServerSocketChannel ssc;
	private volatile boolean stop;
	public static Map<String, SocketChannel> clients = new ConcurrentHashMap<String, SocketChannel>();
	public static ConcurrentHashMap<Object, SelectionKey> selectionkeys = new ConcurrentHashMap<Object, SelectionKey>();

	public ServerTask() {

	}

	public ServerTask(int port) {
		this.stop = false;
		this.port = port;
		initServer();
	}

	public static void main(String[] args) {
		new ServerTask(8888).listen();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				new ServerTask(8888).listen();
				return "started Completed";
			}

		});
		Runnable acceptTask = new Runnable() {
			@Override
			public void run() {
				new ServerTask(8888).listen();
			}
		};
		Thread chkThread = new Thread(task);
		chkThread.setName("beatsCheck");
		chkThread.start();
	}

	private void initServer() {
		try {
			ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(port));
			selector = Selector.open();
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			logger.info("Server init success ....");
		} catch (IOException e) {
			logger.info("Server init failed...");
		}
	}

	private void listen() {
		logger.info("Server start to listen port at " + port);
		while (!stop) {
			try {
				int num = selector.select();
				if (num == 0)
					continue;
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					System.out.println("while"+key.hashCode());
					if (selectionkeys.get(key.hashCode()) == null) {
						System.out.println("sss");
						AcceptTask task = new AcceptTask(key, selector);
						selectionkeys.put(key.hashCode(), key);
						threadPool.submit(task);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (selector != null) {
			try {
				selector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		this.stop = true;
	}

}