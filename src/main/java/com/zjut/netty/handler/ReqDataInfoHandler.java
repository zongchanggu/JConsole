package com.zjut.netty.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Resource;

import org.apache.catalina.tribes.Heartbeat;
import org.apache.log4j.Logger;

import com.zjut.DataFormat.HeartReqInfo;
import com.zjut.DataFormat.HeartReqInfo.HeartReq;
import com.zjut.DataFormat.HeartRspInfo;
import com.zjut.DataFormat.HeartRspInfo.HeartRsp;
import com.zjut.DataFormat.HeartRspInfo.HeartRsp.Builder;
import com.zjut.DataFormat.ReqDataInfo;
import com.zjut.DataFormat.ReqDataInfo.ReqData;
import com.zjut.DataFormat.RspDataInfo;
import com.zjut.DataFormat.RspDataInfo.RspData;
import com.zjut.netty.server.NettyServerThread;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月13日 下午7:39:00
 */
public class ReqDataInfoHandler extends ChannelHandlerAdapter {

	private Logger logger = Logger.getLogger(ReqDataInfoHandler.class);
	private static volatile boolean startCheck = false;
	@Resource
	private JedisPool jedisPool;
	private Map<Integer, String> stateMap = new HashMap<>();
	{
		stateMap.put(0, "normal");
		stateMap.put(1, "undefined");
		stateMap.put(2, "undefined");
		stateMap.put(3, "undefined");
		stateMap.put(4, "undefined");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("Server start read data from client....");
		if (msg == null) {
			logger.info("rcv nothing...");
			return;
		}
		if (msg instanceof ReqDataInfo.ReqData) {
			ReqDataInfo.ReqData req = (ReqDataInfo.ReqData) msg;
			int dev_id = req.getDevId();
			int ad_id = req.getAdId();
			if (NettyServerThread.Adcounts.get(dev_id) == null)
				NettyServerThread.Adcounts.put(dev_id, new AtomicInteger(1));
			else
				NettyServerThread.Adcounts.get(dev_id).getAndIncrement();
			if (NettyServerThread.Devcounts.get(ad_id) == null)
				NettyServerThread.Devcounts.put(ad_id, new AtomicInteger(1));
			else
				NettyServerThread.Devcounts.get(ad_id).getAndIncrement();
			RspDataInfo.RspData rsp = buildRsp(req);
			ctx.writeAndFlush(rsp);
		} else if (msg instanceof HeartReqInfo.HeartReq) {
			if (startCheck) {
				HeartReqInfo.HeartReq heartReq = (HeartReqInfo.HeartReq) msg;
				Jedis jedis = jedisPool.getResource();
				int devId = heartReq.getDevId();
				if (jedis.get(String.valueOf(devId)) == null)
					jedis.setex(String.valueOf(devId), 480, stateMap.get(heartReq.getState()));
			}
		}
		logger.info("ad counts :" + NettyServerThread.Adcounts.get(1));
	}

	private HeartRsp buildHeartRsp() {
		HeartRspInfo.HeartRsp.Builder rsp = HeartRspInfo.HeartRsp.newBuilder();
		rsp.setHead(4);
		rsp.setEnd("$");
		return rsp.build();
	}

	private RspData buildRsp(ReqData req) {
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

	public static void stopCheck() {
		startCheck = false;
	}

	public static void startCheck() {
		startCheck = true;
	}

}
