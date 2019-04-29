package com.C2C.Util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	public static JedisPoolConfig c = new JedisPoolConfig();
	public static JedisPool jedisPool = null;
	/**
	 * 配置文件的地址
	 */
	private static final String PROPERIES_PATH = "redis.properties";
	
	static {
		c.setBlockWhenExhausted(true);//设置连接耗尽柱塞
		c.setLifo(true);//后进先出
		c.setMaxIdle(10);//最大空闲链接数为10
		c.setMinIdle(0);//最少空闲连接数为0
		c.setMaxTotal(100);//最大链接数为100
		c.setMaxWaitMillis(-1);//设置最大等待毫秒数，-1：无限制
		c.setMinEvictableIdleTimeMillis(180);//逐出连接的最小空闲时间为：30分钟
		c.setTestOnBorrow(true);//获取链接数是否检查连接的有效性：是
		c.setTestWhileIdle(true);//空闲时是否检查连接的有效性：是
		
		jedisPool = new JedisPool(c, MyPropertiesUtil.readProperty(PROPERIES_PATH, "url"), 
				Integer.parseInt(MyPropertiesUtil.readProperty(PROPERIES_PATH, "port")));
	}
	
	/**
	 * 获取Jedis连接
	 * @return Jedis连接
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
	
}
