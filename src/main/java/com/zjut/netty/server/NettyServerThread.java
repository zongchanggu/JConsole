package com.zjut.netty.server;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.zjut.DataFormat.ReqDataInfo;
import com.zjut.DataFormat.ReqDataInfo.ReqData;
import com.zjut.netty.handler.ReqDataInfoHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
 * <p>
 * @author:zongchnaggu
 * </p>
 * <p>
 * @description:created by gu
 * </p>
 * <p>
 * @date:2016年12月11日
 * </p>
 *
 */
public class NettyServerThread implements Runnable {
	private static Logger logger = Logger.getLogger(NettyServerThread.class);
	public static ConcurrentHashMap<Integer,AtomicInteger> Adcounts = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<Integer,AtomicInteger> Devcounts = new ConcurrentHashMap<>();
	private int port = 2222;
	private volatile boolean stop = false;

	public NettyServerThread(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		if (!stop) {
			try {
				accept();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void accept() throws InterruptedException {
		EventLoopGroup bossGruop = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGruop, workGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel arg0) throws Exception {
							arg0.pipeline().addLast(new ProtobufDecoder(ReqDataInfo.ReqData.getDefaultInstance()));
							arg0.pipeline().addLast(new ProtobufEncoder());
							arg0.pipeline().addLast(new ReqDataInfoHandler());
							// line based decoder
							// arg0.pipeline().addLast(new
							// LineBasedFrameDecoder(1024));
							// arg0.pipeline().addLast(new StringDecoder());
							//
							// //delimeter based decoder
							// ByteBuf buffer =
							// Unpooled.copiedBuffer("$".getBytes());
							// arg0.pipeline().addLast(new
							// DelimiterBasedFrameDecoder(1024,buffer));
							// arg0.pipeline().addLast(new EchoServerHandler());
							// arg0.pipeline().addLast(new TimeServerHandler());

						}
					}).option(ChannelOption.SO_BACKLOG, 1024);
			logger.info("Server started at port:" + port + ".....");
			ChannelFuture f = b.bind(port).sync();
			f.channel().closeFuture().sync();
		} finally {
			bossGruop.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}

	public void stopServer() {
		if (this.stop == false)
			stop = true;
	}

}
