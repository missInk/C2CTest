package com.C2C.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * ����һ���ַ�����ʽ�ĵ�ǰʱ��
	 * ʱ��ĸ�ʽΪ��yyyy-MM-dd HH:mm:ss
	 * @return �ַ�����ʽ�ĵ�ǰʱ��
	 */
	public static String getNowDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
}
