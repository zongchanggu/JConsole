package com.zjut.netty.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.zjut.controller.DevCheck;
import com.zjut.mapping.DevMapper;
import com.zjut.netty.handler.ReqDataInfoHandler;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Component
public class HealthCheckThread implements Runnable {
	private static Logger logger = Logger.getLogger(HealthCheckThread.class);
	private volatile boolean stop = false;
	@Resource
	private JedisPool jedisPool;
	@Resource
	private SqlSessionTemplate sessionTemplate;
	private Map<String, List<Integer>> maps = new HashMap<>();
	private List<Integer> keys_error1 = new ArrayList<>();
	private List<Integer> keys_error2 = new ArrayList<>();

	@Override
	public void run() {
		logger.info("Start Dev health check... please wait...");
		startCheck();
		try {
			Thread.sleep(380000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stopCheck();
		Jedis jedis = jedisPool.getResource();
		Set<String> keys = jedis.keys("*");
		String[] strs = (String[]) keys.toArray();
		Integer[] intKeys = new Integer[strs.length];
		System.arraycopy(strs, 0, intKeys, 0, intKeys.length);
		List<Integer> conKeys = Arrays.asList(intKeys);
		DevMapper devMapper = sessionTemplate.getMapper(DevMapper.class);
		List<Integer> dbKeys = devMapper.getDevIds();
		conKeys.retainAll(dbKeys);
		dbKeys.removeAll(conKeys);
		maps.put("connect error", dbKeys);
		for (String key : keys) {
			String value = jedis.get(key);
			match(key, value);
		}
		maps.put("infrared sensor error", keys_error1);
		maps.put("undefined", keys_error2);
		DevCheck.latch.countDown();
		for(Integer i : keys_error1)
			logger.info("infrared sensor error :"+i);
	}

	private void match(String key, String value) {
		if (value.equals("infrared sensor error")) {
			keys_error1.add(Integer.parseInt(key));
		} else if (value.equals("")) {
			keys_error2.add(Integer.parseInt(key));
		} else {

		}
	}

	public void stopCheck() {
		ReqDataInfoHandler.stopCheck();
	}

	public void startCheck() {
		ReqDataInfoHandler.startCheck();
	}

}
