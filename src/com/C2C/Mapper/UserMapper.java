package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.User;

public interface UserMapper {

	/**
	 * ͨ���û���id����ȡ�û��ĵ��û���
	 * @param idUser �û���id
	 * @return �û��ĵ��û���
	 */
	String getUserNameByIduser(int idUser);
	
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
	
}
