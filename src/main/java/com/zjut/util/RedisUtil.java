package com.zjut.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjut.pojo.Advertise;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月13日</p>
 *
 */
public class RedisUtil {
	
//	@Resource
//	private JedisPool jedisPool;
	
	public Jedis newRedisCli(String host,int port,String pwd){
		Jedis jedis = new Jedis(host, port);
		jedis.auth(pwd);
		return jedis;
	}
	
	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
//		JedisPool pool = (JedisPool) context.getBean("jedisPool");
//		Jedis jedis = pool.getResource();
//		System.out.println(jedis.get("test"));
		Jedis jedis = new Jedis("112.74.191.195", 6379);
		jedis.auth("qaz123456");
		Advertise ad = new Advertise();
		ad.setAdName("shjo");
		Advertise ad2 = new Advertise();
		ad2.setAdName("dvh");
		List<String> strs = new ArrayList<>();
		strs.add(ad2.toString());
		strs.add(ad.toString());
		String[] ass = (String[]) strs.toArray(new String[strs.size()]);
		jedis.sadd("ads",ass);
	}
	
	
}
