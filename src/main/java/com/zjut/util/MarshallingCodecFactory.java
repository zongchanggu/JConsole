package com.zjut.util;

import java.io.IOException;

import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;

/**
 * 
 * <p>
 * 
 * @author:zongchnaggu
 *                     </p>
 *                     <p>
 * @description:created by gu
 *                      </p>
 *                      <p>
 * @date:2016年12月7日
 *                  </p>
 *
 */
public class MarshallingCodecFactory {

	public static MarshallingDecoder getNettyMarshallingDecoder() {
		final MarshallerFactory fac = Marshalling.getProvidedMarshallerFactory("serial");
		final MarshallingConfiguration conf = new MarshallingConfiguration();
		conf.setVersion(5);
		UnmarshallerProvider provider = new DefaultUnmarshallerProvider(fac, conf);
		MarshallingDecoder decoder = new MarshallingDecoder(provider);
		return decoder;
	}

	public static MarshallingEncoder getNettyMarshallingEncoder() {
		final MarshallerFactory fac = Marshalling.getProvidedMarshallerFactory("serial");
		final MarshallingConfiguration conf = new MarshallingConfiguration();
		conf.setVersion(5);
		MarshallerProvider provider = new DefaultMarshallerProvider(fac, conf);
		MarshallingEncoder encoder = new MarshallingEncoder(provider);
		return encoder;
	}

	public static void getMarshallingDecoder(String bytes) {
		final MarshallerFactory fac = Marshalling.getProvidedMarshallerFactory("serial");
		final MarshallingConfiguration conf = new MarshallingConfiguration();
		conf.setVersion(5);
		Unmarshaller shaller = null;
		try {
			shaller = fac.createUnmarshaller(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	ByteInput input = new ChannelBufferByteInput(bytes.getBytes());
		}
}
