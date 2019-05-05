package com.C2C.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class MyCacheUtil {

	public static <T> List<T> getList(String key, Class<T> t, int star, int end) {
		List<T> list = new ArrayList<T>();

		Jedis jedis = null;
		try {
			jedis = JedisPoolUtils.getJedis();
		} catch (Exception e) {
			return null;
		}

		Set<String> zrange = jedis.zrange(key, star, end);
		Iterator<String> iterator = zrange.iterator();
		while (iterator.hasNext()) {
			String jsonStr = iterator.next();
			@SuppressWarnings("unchecked")
			T obj = (T) MyJsonUtil.getDtoFromJsonObjStr(jsonStr, t);
			list.add(obj);
		}
		return list;
	}

	public static <T> void addList(String key, List<T> t) {
		Jedis jedis = null;
		try {
			jedis = JedisPoolUtils.getJedis();
		} catch (Exception e) {
			return;
		}
		Iterator<T> iterator = t.iterator();
		while (iterator.hasNext()) {
			String jsonStr = MyJsonUtil.Obj_to_json(iterator.next());
			jedis.zadd(key, 0, jsonStr);
		}
	}

}
