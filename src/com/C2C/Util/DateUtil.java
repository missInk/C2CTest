package com.C2C.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 返回一个字符串形式的当前时间
	 * 时间的格式为：yyyy-MM-dd HH:mm:ss
	 * @return 字符串形式的当前时间
	 */
	public static String getNowDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
}
