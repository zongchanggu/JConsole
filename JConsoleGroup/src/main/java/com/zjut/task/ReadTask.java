package com.zjut.task;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ReadTask extends AbstractTask{

	public ReadTask(){
		
	}
	public ReadTask(SelectionKey key, Selector selector) {
		super(key, selector);
	}

	@Override
	public void handle(SelectionKey key) throws IOException {
		
	}

	@Override
	public void doWrite(SocketChannel client, String response) throws IOException {
		
	}

	@Override
	public void dispatch(SocketChannel client, String info) throws IOException {
		
	}

}
