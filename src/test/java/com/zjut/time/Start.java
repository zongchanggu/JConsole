package com.zjut.time;

import com.zjut.task.Notifier;
import com.zjut.task.Server;

public class Start {

	public static void main(String[] args) {
		try {
			LogHandler loger = new LogHandler();
			TimeHandler timer = new TimeHandler();
			Notifier notifier = Notifier.getNotifier();
			notifier.addListener(loger);
			notifier.addListener(timer);
			System.out.println("Server starting ...");
			Server server = new Server(8888);
			Thread tServer = new Thread(server);
			tServer.start();
		} catch (Exception e) {
			System.out.println("Server error: " + e.getMessage());
			System.exit(-1);
		}
	}
}
