package com.zjut.time;

import java.util.*;

import com.zjut.task.Request;
import com.zjut.task.Response;
import com.zjut.task.event.EventAdapter;
import java.text.DateFormat;

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
//		if(new String(request.getDataInput()).equals("hello world"))
			response.send("hello".getBytes());
//		response.send(time.getBytes());
	}
}
