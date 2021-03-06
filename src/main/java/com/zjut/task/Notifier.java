package com.zjut.task;

import java.util.ArrayList;

import com.zjut.task.event.ServerListener;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class Notifier {
	private static ArrayList<ServerListener> listeners = null;
	private static Notifier instance = null;

	private Notifier() {
		listeners = new ArrayList<ServerListener>();
	}

	public static synchronized Notifier getNotifier() {
		if (instance == null) {
			instance = new Notifier();
			return instance;
		} else
			return instance;
	}

	public void addListener(ServerListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l))
				listeners.add(l);
		}
	}

	public void fireOnAccept() throws Exception {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onAccept();
	}

	public void fireOnAccepted(Request request) throws Exception {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onAccepted(request);
	}

	void fireOnRead(Request request) throws Exception {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onRead(request);

	}

	void fireOnWrite(Request request, Response response) throws Exception {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onWrite(request, response);

	}

	public void fireOnClosed(Request request) throws Exception {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onClosed(request);
	}

	public void fireOnError(String error) {
		for (int i = listeners.size() - 1; i >= 0; i--)
			((ServerListener) listeners.get(i)).onError(error);
	}
}
