package com.C2C.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyJsonUtil {

	/**
	 * 将一个json格式的字符串转换为对应的对象
	 * @param <T>
	 * @param jsonObjStr
	 *            json格式的字符串
	 * @param clazz
	 *            对应的class
	 * @return 转换后的对象
	 */
	public static <T> Object getDtoFromJsonObjStr(String jsonObjStr, Class<T> t) {
		return JSONObject.toBean(JSONObject.fromObject(jsonObjStr), t);
	}

	/**
	 * 把一个json数组串转换成实体数组
	 * @param <T>
	 * @param jsonArrStr
	 * @param clazz
	 * @return Object[]
	 */
	public static <T> Object[] getDtoArrFromJsonArrStr(String jsonArrStr, Class<T> t) {
		JSONArray jsonArr = JSONArray.fromObject(jsonArrStr);
		Object[] objArr = new Object[jsonArr.size()];
		for (int i = 0; i < jsonArr.size(); i++) {
			objArr[i] = JSONObject.toBean(jsonArr.getJSONObject(i), t);
		}
		return objArr;
	}
	
	public static String Obj_to_json(Object obj) {
		return JSONObject.fromObject(obj).toString();
	}
	
}
