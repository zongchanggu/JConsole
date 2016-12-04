package com.zjut.task;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Map;

import org.apache.ibatis.cache.decorators.SynchronizedCache;

public class AcceptTask extends AbstractTask {

	public AcceptTask(SelectionKey key, Selector selector) {
		super(key, selector);
	}

	public AcceptTask(SelectionKey key, Selector selector, String taskName) {
		this(key, selector);
		this.taskName = taskName;
	}

	@Override
	public void handle(SelectionKey key) throws IOException {

		ServerSocketChannel server = null;
		SocketChannel client = null;
		if (key.isValid()) {
			if (key.isAcceptable()) {
				server = (ServerSocketChannel) key.channel();
				client = server.accept();
				client.configureBlocking(false);
				System.out.println("handle");
				client.register(selector, SelectionKey.OP_READ);
				System.out.println("process acceptable....");
			}
			if (key.isReadable()) {
				System.out.println("read");
				client = (SocketChannel) key.channel();
				ServerTask.clients.put(client.toString(), client);
				ByteBuffer readBuffer = ByteBuffer.allocate(512);
				int byteNum = client.read(readBuffer);
				// 半包问题待解决
				if (byteNum > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					logger.info(client.toString() + ":" + body + "\t Sending repsonse data to client...");
					String response = "hello fk ...";
					doWrite(client, response);// 回写
					System.out.println("process readable...");
					// 广播所有客户端信息
					// dispatch(client, response);
					// ?没完成，继续注册监听事件
					// client = (SocketChannel) key.channel();
					// client.register(selector, SelectionKey.OP_READ);
				} else if (byteNum < 0) {
					key.cancel();
					ServerTask.clients.remove(client.toString());
					client.close();
					ServerTask.selectionkeys.remove(key.hashCode());
					logger.info("client closed....");
				} else
					logger.info("no bytes....");
			}
		}
	}

	@Override
	public void doWrite(SocketChannel client, String response) throws IOException {
		if (response != null && response.trim().length() != 0) {
			byte[] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			client.write(writeBuffer);
		}
	}

	@Override
	public void dispatch(SocketChannel client, String info) throws IOException {
		if (info != null && info.trim().length() != 0) {
			Socket socket = client.socket();
			String name = "[" + socket.getInetAddress().toString().substring(1) + Integer.toHexString(client.hashCode())
					+ "]:";
			if (ServerTask.clients != null)
				for (Map.Entry<String, SocketChannel> ct : ServerTask.clients.entrySet()) {
					SocketChannel sc = ct.getValue();
					if (!sc.equals(client)) {
						String response = name + info;
						ByteBuffer writeBuffer = ByteBuffer.allocate(response.length());
						writeBuffer.put(response.getBytes());
						writeBuffer.flip();
						sc.write(writeBuffer);
					}
				}
		}
	}
}
