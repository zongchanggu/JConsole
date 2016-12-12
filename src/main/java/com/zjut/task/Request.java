package com.zjut.task;

import java.net.InetAddress;
import java.nio.channels.SocketChannel;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class Request {
	private SocketChannel sc;
	private byte[] dataInput = null;;
	Object obj;

	public Request(SocketChannel sc) {
		this.sc = sc;
	}

	public InetAddress getAddress() {
		return sc.socket().getInetAddress();
	}

	public int getPort() {
		return sc.socket().getPort();
	}

	public boolean isConnected() {
		return sc.isConnected();
	}

	public boolean isBlocking() {
		return sc.isBlocking();
	}

	public boolean isConnectionPending() {
		return sc.isConnectionPending();
	}

	public boolean getKeepAlive() throws java.net.SocketException {
		return sc.socket().getKeepAlive();
	}

	public int getSoTimeout() throws java.net.SocketException {
		return sc.socket().getSoTimeout();
	}

	public boolean getTcpNoDelay() throws java.net.SocketException {
		return sc.socket().getTcpNoDelay();
	}

	public boolean isClosed() {
		return sc.socket().isClosed();
	}

	public void attach(Object obj) {
		this.obj = obj;
	}

	public Object attachment() {
		return obj;
	}

	public byte[] getDataInput() {
		return dataInput;
	}

	public void setDataInput(byte[] dataInput) {
		this.dataInput = dataInput;
	}
}
