package com.C2C.Service;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;

public interface UserService {

	/**
	 * ����û��Ƿ�Ϸ�
	 * @param email �û�������
	 * @param password �û�������
	 * @return �Ϸ����û�������  ���Ϸ���null
	 */
	Integer checkUser(String email, String password);
	
	/**
	 * �����û�����������뷵���û��Ļ�����Ϣ
	 * @param email �û�������
	 * @param password �û�������
	 * @return �û��Ļ�����Ϣ
	 */
	User getUserInfo(String email, String password);
	
	/**
	 * ���û�����������뱣�浽cookie��
	 * @param email �û�������
	 * @param password �û�������
	 * @return �����û�����������cookie
	 */
	Cookie newCookie(String email, String password);
}
