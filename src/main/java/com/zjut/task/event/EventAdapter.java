package com.zjut.task.event;

import com.zjut.task.event.ServerListener;

import org.apache.log4j.Logger;

import com.zjut.task.Request;
import com.zjut.task.Response;

public abstract class EventAdapter implements ServerListener {
	protected static Logger logger = Logger.getLogger(EventAdapter.class);
	public EventAdapter() {
	}

	public void onError(String error) {
	}

	public void onAccept() throws Exception {
	}

	public void onAccepted(Request request) throws Exception {
	}

	public void onRead(Request request) throws Exception {
	}

	public void onWrite(Request request, Response response) throws Exception {
	}

	public void onClosed(Request request) throws Exception {
	}
}
