package com.zjut.task;

import com.zjut.task.event.EventAdapter;

public class ServerHandler extends EventAdapter {
	public ServerHandler() {
	}

	public void onAccept() throws Exception {
		System.out.println("accept request");
	}

	public void onAccepted(Request request) throws Exception {
		System.out.println("connect establish");
	}

	public void onRead(Request request) throws Exception {
		System.out.println("server read");
		// byte[] rspData = data;
		// if (new String (data).equalsIgnoreCase("query")) {
		// rspData = new java.util.Date().toString().getBytes();
		// }
		// request.attach(rspData);
		// System.out.println("#onRead()");
		request.attach(new java.util.Date().toString().getBytes());
		System.out.println("received:" + request.attachment().toString());
	}

	public void onWrite(Request request, Response response) throws Exception {
		 System.out.println("server write");
		 response.send((byte[])request.attachment());
		 response.send("OK".getBytes());
	}

	public void onClosed(Request request) throws Exception {
		 System.out.println("close connection");
	}

	public void onError(String error) {
		System.out.println("connect error:" + error);
	}
}
