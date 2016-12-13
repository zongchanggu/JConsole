package com.zjut.util;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	
	@Resource
	private JedisPool jedisPool;
	
	public Jedis newRedisCli(String host,int port,String pwd){
		Jedis jedis = new Jedis(host, port);
		jedis.auth(pwd);
		return jedis;
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
		JedisPool pool = (JedisPool) context.getBean("jedisPool");
		Jedis jedis = pool.getResource();
		System.out.println(jedis.get("test"));
	}
	
	
}
