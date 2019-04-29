package com.C2C.Util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	public static JedisPoolConfig c = new JedisPoolConfig();
	public static JedisPool jedisPool = null;
	/**
	 * �����ļ��ĵ�ַ
	 */
	private static final String PROPERIES_PATH = "redis.properties";
	
	static {
		c.setBlockWhenExhausted(true);//�������Ӻľ�����
		c.setLifo(true);//����ȳ�
		c.setMaxIdle(10);//������������Ϊ10
		c.setMinIdle(0);//���ٿ���������Ϊ0
		c.setMaxTotal(100);//���������Ϊ100
		c.setMaxWaitMillis(-1);//�������ȴ���������-1��������
		c.setMinEvictableIdleTimeMillis(180);//������ӵ���С����ʱ��Ϊ��30����
		c.setTestOnBorrow(true);//��ȡ�������Ƿ������ӵ���Ч�ԣ���
		c.setTestWhileIdle(true);//����ʱ�Ƿ������ӵ���Ч�ԣ���
		
		jedisPool = new JedisPool(c, MyPropertiesUtil.readProperty(PROPERIES_PATH, "url"), 
				Integer.parseInt(MyPropertiesUtil.readProperty(PROPERIES_PATH, "port")));
	}
	
	/**
	 * ��ȡJedis����
	 * @return Jedis����
	 */
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
	
}
