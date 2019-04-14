package com.C2C.Service;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;

public interface UserService {

	/**
	 * ����û��Ƿ�Ϸ�
	 * @param email �û�������
	 * @param passWord �û������� [����������MD5����]
	 * @return �Ϸ����û�������  ���Ϸ���null
	 */
	Integer checkUser(String email, String passWord);
	
	/**
	 * �����û�����������뷵���û��Ļ�����Ϣ
	 * @param email �û�������
	 * @param passWord �û�������
	 * @return �û��Ļ�����Ϣ(�û�ID���û������û�ͷ���û��Ա��û�ѧУ)
	 */
	User getUserInfo(String email, String passWord);
	
	/**
	 * ���û�����������뱣�浽cookie��
	 * @param email �û�������
	 * @param passWord �û�������
	 * @return �����û�����������cookie
	 */
	Cookie newCookie(String email, String passWord);
	
	/**
	 * ����û���������������ʽ�Ƿ���ȷ
	 * @param email �û����������
	 * @return ��ʽ��ȷ��true ����false
	 */
	boolean checkEmailStyle(String email);
	
	/**
	 * ����û���������������Ƿ�һ��
	 * @param password ��һ�����������
	 * @param repassword �ظ����������
	 * @return �������������һ�£�true ������������벻һ�£�false
	 */
	boolean checkPassword(String passWord, String repassWord);
	
	/**
	 * �û�ע��
	 * @param email �û�ע�������
	 * @param userName �û����û���
	 * @param password �û������� [����������MD5����]
	 * @param ecode ������֤��
	 * @return ע��ɹ���true ע��ʧ�ܣ�false
	 */
	boolean regist(String email, String userName, String passWord, String ecode);
	
	/**
	 * ���ĳ�������Ƿ���Ա�ע��
	 * @param email ����������
	 * @return ����ע�᣺true ����ע�᣺false
	 */
	boolean checkEmailRegist(String email);
	
	/**
	 * ͨ�������˺Ż�ȡ�û���Ϣ(���� ����)
	 * @param alipay �����˺�
	 * @return �û��Ĳ�����Ϣ
	 */
	User getUserByAlipay(String alipay);
}
