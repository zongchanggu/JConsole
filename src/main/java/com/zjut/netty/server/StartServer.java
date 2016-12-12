package com.zjut.netty.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
@Component("processor")
public class StartServer extends HttpServlet{
    
	private static final long serialVersionUID = 6633498817482630363L;
	private static Logger logger = Logger.getLogger(StartServer.class);
	
	@Override
	public void init() throws ServletException {
		Runnable task = new NettyServerThread(8888);
		new Thread(task).start();
	}

}
