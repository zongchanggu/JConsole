package com.zjut.task;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Map;

import org.apache.log4j.Logger;

public abstract class AbstractTask implements Runnable {
	protected volatile SelectionKey key;
	protected Selector selector;

	protected String taskName;
	public volatile boolean flag = false;


	protected Logger logger = Logger.getLogger(AbstractTask.class);
	public AbstractTask(){
		
	}

	public AbstractTask(SelectionKey key, Selector selector) {
		this.key = key;
		this.selector = selector;
	}

	public abstract void handle(SelectionKey key) throws IOException;

	// 单播
	public abstract void doWrite(SocketChannel client, String response) throws IOException;

	// 广播
	public abstract void dispatch(SocketChannel client, String info) throws IOException;


	public void preInvoke() {
		logger.info("pre task init...");
	}

	public void postInvoke() {
		logger.info("post task end...");
	}

	@Override
	public void run() {
		preInvoke();
		try {
			handle(key);
		} catch (IOException e) {
			logger.info("client task failed...");
			e.printStackTrace();
		}
		postInvoke();
	}

}
