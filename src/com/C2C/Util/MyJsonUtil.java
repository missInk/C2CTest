package com.C2C.Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyJsonUtil {

	/**
	 * ��һ��json��ʽ���ַ���ת��Ϊ��Ӧ�Ķ���
	 * @param <T>
	 * @param jsonObjStr
	 *            json��ʽ���ַ���
	 * @param clazz
	 *            ��Ӧ��class
	 * @return ת����Ķ���
	 */
	public static <T> Object getDtoFromJsonObjStr(String jsonObjStr, Class<T> t) {
		return JSONObject.toBean(JSONObject.fromObject(jsonObjStr), t);
	}

	/**
	 * ��һ��json���鴮ת����ʵ������
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
