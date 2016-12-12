package com.zjut.task;

import com.zjut.task.event.EventAdapter;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class ServerHandler extends EventAdapter {
	public ServerHandler() {
	}

	public void onAccept() throws Exception {
		logger.info("accept request");
	}

	public void onAccepted(Request request) throws Exception {
		logger.info("connect establish");
	}

	public void onRead(Request request) throws Exception {
		logger.info("server read");
		// byte[] rspData = data;
		// if (new String (data).equalsIgnoreCase("query")) {
		// rspData = new java.util.Date().toString().getBytes();
		// }
		// request.attach(rspData);
		request.attach(new java.util.Date().toString().getBytes());
		logger.info("received:" + request.attachment().toString());
	}

	public void onWrite(Request request, Response response) throws Exception {
		 logger.info("server write");
		 response.send((byte[])request.attachment());
		 response.send("OK".getBytes());
	}

	public void onClosed(Request request) throws Exception {
		 logger.info("close connection");
	}

	public void onError(String error) {
		logger.info("connect error:" + error);
	}
}
