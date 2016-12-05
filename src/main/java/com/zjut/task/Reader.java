package com.zjut.task;

import java.util.List;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.nio.channels.SocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.ByteBuffer;
import java.io.IOException;

public class Reader extends Thread {
	private static Logger logger = Logger.getLogger(Reader.class);
	private static List<Object> pool = new LinkedList<Object>();
	private static Notifier notifier = Notifier.getNotifier();

	public Reader() {
	}

	public void run() {
		while (true) {
			try {
				SelectionKey key;
				synchronized (pool) {
					while (pool.isEmpty()) {
						pool.wait();
					}
					key = (SelectionKey) pool.remove(0);
				}
				read(key);
			} catch (Exception e) {
				continue;
			}
		}
	}

	private static int BUFFER_SIZE = 1024;

	public static byte[] readRequest(SocketChannel sc) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		int off = 0;
		int r = 0;
		byte[] data = new byte[BUFFER_SIZE * 10];

//		while (true) {
//			buffer.clear();
//			r = sc.read(buffer);
//			System.out.println(new String(buffer.array()));
//			if (r == -1)
//				break;
//			if ((off + r) > data.length) {
//				data = grow(data, BUFFER_SIZE * 10);
//			}
//			byte[] buf = buffer.array();
//			System.arraycopy(buf, 0, data, off, r);
//			off += r;
//		}
//		byte[] req = new byte[off];
//		System.arraycopy(data, 0, req, 0, off);
//		System.out.println(new String(req));
		buffer.clear();
		sc.read(buffer);
		logger.info(new String(buffer.array(),"UTF-8"));
		return buffer.array();
	}

	public void read(SelectionKey key) {
		try {
			SocketChannel sc = (SocketChannel) key.channel();
			byte[] clientData = readRequest(sc);
			Request request = (Request) key.attachment();
			request.setDataInput(clientData);
			notifier.fireOnRead(request);
			Server.processWriteRequest(key);
		} catch (Exception e) {
			notifier.fireOnError("Error occured in Reader: " + e.getMessage());
		}
	}

	public static void processRequest(SelectionKey key) {
		synchronized (pool) {
			pool.add(pool.size(), key);
			pool.notifyAll();
		}
	}

	public static byte[] grow(byte[] src, int size) {
		byte[] tmp = new byte[src.length + size];
		System.arraycopy(src, 0, tmp, 0, src.length);
		return tmp;
	}
}
