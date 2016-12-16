package com.zjut.netty.server;

import org.apache.log4j.Logger;
import com.zjut.DataFormat.HeartReqInfo;
import com.zjut.netty.handler.ReqDataInfoHandler;
import com.zjut.netty.handler.ReqHealthInfoHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * 
 * @author:zongchnaggu
 * @description:created by gu
 * @date:2016年12月16日 下午1:05:10
 */
public class NettyHealthChkServerThread implements Runnable {
	private Logger logger = Logger.getLogger(NettyHealthChkServerThread.class);
	private int port = 2223;
	private static volatile boolean stop = false;

	public NettyHealthChkServerThread(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		if(!stop){
			try {
				acceptHealthChk();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void acceptHealthChk() throws InterruptedException {
		EventLoopGroup workGroup = new NioEventLoopGroup();
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel arg0) throws Exception {
							arg0.pipeline().addLast(new ProtobufDecoder(HeartReqInfo.HeartReq.getDefaultInstance()));
							arg0.pipeline().addLast(new ProtobufEncoder());
							arg0.pipeline().addLast(new ReqHealthInfoHandler());
						}
					}).option(ChannelOption.SO_BACKLOG, 1024);
			logger.info("HealthChk  Server started at port:" + port + ".....");
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
	
	public void stopHealthChkServer(){
		this.stop = true;
	}
}
