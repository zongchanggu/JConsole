package com.zjut.task;

import java.util.Date;

import com.zjut.task.event.EventAdapter;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
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
