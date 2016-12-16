package com.zjut.netty.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月16日 下午1:19:13
 */
@Component("processor")
public class StartServer extends HttpServlet {

	private static final long serialVersionUID = 6633498817482630363L;
	private static Logger logger = Logger.getLogger(StartServer.class);

	@Override
	public void init() throws ServletException {
		logger.info("init server ....");
		Runnable task = new NettyServerThread(8888);
		new Thread(task).start();
		Runnable healthChktask = new NettyHealthChkServerThread(8889);
		new Thread(healthChktask).start();
	}

}
