package com.zjut.cache;

import org.apache.log4j.Logger;
import com.zjut.util.PropertiesUtil;
import redis.clients.jedis.Jedis;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月13日</p>
 *
 */
public class JedisCache {

	private static Logger logger = Logger.getLogger(JedisCache.class);
	private String host = "localhost";
	private int port = 6379;
	private Jedis jedis;
	private String password;
	private static JedisCache jedisCache;

	private JedisCache() {
		initParameters();
		jedis = new Jedis(host, port);
		jedis.auth(password);
	}

	private void initParameters(){
		this.host = PropertiesUtil.getValueByKey("host");
		this.port = Integer.parseInt(PropertiesUtil.getValueByKey("port"));
		this.password = PropertiesUtil.getValueByKey("password");
	}

	public static JedisCache getInstance() {
		if (jedisCache == null) {
			synchronized (JedisCache.class) {
				if (jedisCache == null) {
					logger.info("Construct JedisCache object....");
					jedisCache = new JedisCache();
				}
				return jedisCache;
			}
		}
		return jedisCache;
	}

	public static Jedis getJedisInstance() {
		if (jedisCache != null)
			return jedisCache.getJedis();
		return getInstance().getJedis();
	}

	public Jedis getJedis() {
		return jedis;
	}

	public static void main(String[] args) {
		Jedis a =JedisCache.getJedisInstance();
		a.set("test","hello world");
		logger.info(a.get("test"));
	}
}
