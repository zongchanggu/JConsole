package com.zjut.netty.handler;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import com.zjut.DataFormat.ReqDataInfo;
import com.zjut.DataFormat.RspDataInfo;
import com.zjut.netty.server.NettyServerThread;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class ReqDataInfoHandler extends ChannelHandlerAdapter {

	private Logger logger = Logger.getLogger(ReqDataInfoHandler.class);

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("Server start read data from client....");
		ReqDataInfo.ReqData req = (ReqDataInfo.ReqData) msg;
		int dev_id = req.getDevId();
		int ad_id = req.getAdId();
		if(NettyServerThread.Adcounts.get(dev_id)==null){
			NettyServerThread.Adcounts.put(dev_id,new AtomicInteger(1));
		}
		else{
			NettyServerThread.Adcounts.get(dev_id).getAndIncrement(); 
		}
		if(NettyServerThread.Devcounts.get(ad_id)==null){
			NettyServerThread.Devcounts.put(ad_id,new AtomicInteger(1));
		}
		else
			NettyServerThread.Devcounts.get(ad_id).getAndIncrement();
		RspDataInfo.RspData rsp = buildObj(req);
		ctx.writeAndFlush(rsp);
		System.out.println("ad counts :"+ NettyServerThread.Adcounts.get(1));
	}
	
	public RspDataInfo.RspData buildObj(ReqDataInfo.ReqData req){
		RspDataInfo.RspData.Builder builder = RspDataInfo.RspData.newBuilder();
		builder.setHead(2);
		builder.setClientHead(req.getHead());
		builder.setEnd("$");
		return builder.build();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.info("exception occured....");
		logger.info(cause.getMessage());
		ctx.close();
	}

	@Override
	public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
		logger.info("Server closed....");
		ctx.close();
	}

}
