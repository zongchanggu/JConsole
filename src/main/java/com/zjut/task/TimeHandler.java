package com.zjut.task;

import java.util.*;

import com.zjut.task.event.EventAdapter;
import java.text.DateFormat;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class TimeHandler extends EventAdapter {
	public TimeHandler() {
	}

	public void onWrite(Request request, Response response) throws Exception {
		String command = new String(request.getDataInput());
		String time = null;
		Date date = new Date();
		if (command.equals("GB")) {
			DateFormat cnDate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA);
			time = cnDate.format(date);
		} else {
			DateFormat enDate = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.US);
			time = enDate.format(date);
		}
		response.send("hello".getBytes());
	}
}
