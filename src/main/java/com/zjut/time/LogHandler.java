package com.zjut.time;

import java.util.Date;

import com.zjut.task.Request;
import com.zjut.task.event.EventAdapter;

public class LogHandler extends EventAdapter {
	public LogHandler() {
	}

	public void onClosed(Request request) throws Exception {
		String log = new Date().toString() + " from " + request.getAddress().toString();
		logger.info(log);
	}

	public void onError(String error) {
		logger.info("Error: " + error);
	}
}
