package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.User;

public interface UserMapper {

	/**
	 * ͨ���û���id������û���ʵ��
	 * @param idUser �û���id
	 * @return �û���ʵ��(�û�ID���û������û�ͷ���û��Ա��û�ѧУ)
	 */
	User getUserByIdUser(int idUser);
	
	/**
	 * ͨ���û�id������û��ļ���Ϣ
	 * @param idUser �û�id
	 * @return �û��ļ���Ϣ���û������û�ͷ��
	 */
	User getUserInfo(int idUser);
	
	/**
	 * ����û��Ƿ�Ϸ�
	 * @param email �û�������
	 * @param password �û�������
	 * @return �Ϸ����û�������  ���Ϸ���null
	 */
	Integer checkUser(@Param("email")String email, @Param("password")String password);
	
	/**
	 * �û�ע��
	 * @param email �û�ע�������
	 * @param userName �û����û���
	 * @param password �û�������
	 * @return ע��ɹ���1 ע��ʧ�ܣ�0
	 */
	int regist(@Param("email")String email, @Param("userName")String userName, @Param("passWord")String passWord);
	
	/**
	 * ���ĳ�������Ƿ��Ѿ���ע��
	 * @param email ����������
	 * @return ��ע�᣺���û���idUser û��ע�᣺null
	 */
	Integer checkEmailRegist(String email);
	
	/**
	 * ͨ�������˺Ż�ȡ�û���Ϣ
	 * @param alipay �����˺�
	 * @return �û��Ĳ�����Ϣ
	 */
	User getUserByAlipay(String alipay);
	
	/**
	 * ��֧�����˺� 
	 * @param email ���󶨵�����
	 * @param alipay ֧����id
	 * @return �ɹ� true ʧ��false
	 */
	boolean binding(@Param("email")String email, @Param("alipay")String alipay);
	
	/**
	 * ��ȡͷ��
	 * @param email ����ȡ���˺ŵ�����
	 * @return ͷ���ַ
	 */
	String getHeadPortrait(String email);
	
}
