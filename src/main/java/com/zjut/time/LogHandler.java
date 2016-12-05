package com.zjut.time;

import java.util.Date;

import com.zjut.task.Request;
import com.zjut.task.event.EventAdapter;

public class LogHandler extends EventAdapter {
	public LogHandler() {
	}

	public void onClosed(Request request) throws Exception {
		String log = new Date().toString() + " from " + request.getAddress().toString();
		System.out.println(log);
	}

	public void onError(String error) {
		System.out.println("Error: " + error);
	}
}
