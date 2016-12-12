package com.zjut.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
@Controller
@RequestMapping("ServerAction")
public class ServerAction {

	private Logger logger = Logger.getLogger(ServerSocket.class);
	private ExecutorService threadPool = Executors.newCachedThreadPool();

	@RequestMapping("buildCon")
	public String buildConnection() {
		try {
			ServerSocket server = new ServerSocket(8888);
			while (true) {
				System.out.println("jjgd");
				Socket socket = server.accept();
				logger.info("IP:" + socket.getInetAddress() + "connection build");
				Thread thread = new Thread(new HandleThread(socket));
				// threadPool.execute(thread);
				thread.start();
			}
		} catch (IOException e) {
			logger.info("server failed");
		}
		return "index";
	}

	class HandleThread implements Runnable {
		private Socket socket;

		public HandleThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				System.out.println("dej");
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				PrintWriter pw = new PrintWriter(os);
				// Scanner sc = new Scanner(is);
				System.out.println("rcv from :" + reader.readLine());
				BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
				os.write("11hello fk\0".getBytes());
				pw.write("hello gzc".toCharArray());
				// pw.write("info:"+sc.nextLine());
				System.out.println("hihi");
			} catch (IOException e) {
				logger.info("get IO stream failed..");
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					logger.info("close failed...");
					e.printStackTrace();
				}
			}
		}

	}

	@RequestMapping("handleRequest")
	public String handleRequest() {
		HandleServer server = new HandleServer(8888);
		new Thread(server).start();
		return "index";
	}

	class HandleServer implements Runnable {
		private ServerSocketChannel serverSocket;
		private Selector selector;
		private volatile boolean stop;

		public HandleServer(int port) {
			try {
				serverSocket = ServerSocketChannel.open();
				selector = Selector.open();
				serverSocket.configureBlocking(false);
				serverSocket.socket().bind(new InetSocketAddress("192.168.1.143", port));
				serverSocket.register(selector, SelectionKey.OP_ACCEPT);
				logger.info("the server start in port " + port);
			} catch (IOException e) {
				System.exit(1);
			}
		}

		@Override
		public void run() {
			while (!stop) {
				try {
					int num = selector.select(1000);
					if(num == 0)
						continue;
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> it = keys.iterator();
					SelectionKey key = null;
					while (it.hasNext()) {
						key = it.next();
						it.remove();
						handleKey(key);
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

		private void handleKey(SelectionKey key) throws IOException {
			if (key.isValid()) {
				if (key.isAcceptable()) {
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
				}
				if(key.isReadable()){
					SocketChannel sc = (SocketChannel) key.channel();
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					int byteNum = sc.read(readBuffer);
					if(byteNum > 0){
						readBuffer.flip();
						byte[] bytes = new byte[readBuffer.remaining()];
						readBuffer.get(bytes);
						String body = new String(bytes,"UTF-8");
						doWrite(sc, "hello fk");
					}
					else if(byteNum < 0){
						key.cancel();
						sc.close();
					}
					else{
						logger.info("get nothing byte");
					}
				}
			}
		}
		
		private void doWrite(SocketChannel sc, String response) throws IOException{
			if(response!=null && response.trim().length()!=0){
				byte[] bytes = response.getBytes();
				ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
				writeBuffer.put(bytes);
				writeBuffer.flip();
				sc.write(writeBuffer);
			}
		}
		public void stop() {
			this.stop = true;
		}

	}

}
