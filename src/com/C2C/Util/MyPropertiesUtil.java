package com.C2C.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyPropertiesUtil {

	/**
	 * 获得配置文件的某一个key的值
	 * @param properiesPath 配置文件的路径
	 * @param key key的名称
	 * @return key的值
	 */
	public static String readProperty(String properiesPath, String key) {
        String value = "";
        InputStream is = null;
        try {
            is = MyPropertiesUtil.class.getClassLoader().getResourceAsStream(properiesPath);
            Properties p = new Properties();
            p.load(is);
            value = p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
	
}
