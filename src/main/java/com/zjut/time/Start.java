package com.zjut.time;

import org.apache.log4j.Logger;

import com.zjut.task.Notifier;
import com.zjut.task.Server;

public class Start {
	private static Logger logger = Logger.getLogger(Start.class);

	public static void main(String[] args) {
		try {
			LogHandler loger = new LogHandler();
			TimeHandler timer = new TimeHandler();
			Notifier notifier = Notifier.getNotifier();
			notifier.addListener(loger);
			notifier.addListener(timer);
			logger.info("Server starting ...");
			Server server = new Server(8888);
			Thread tServer = new Thread(server);
			tServer.start();
		} catch (Exception e) {
			logger.info("Server error: " + e.getMessage());
			System.exit(-1);
		}
	}
}
