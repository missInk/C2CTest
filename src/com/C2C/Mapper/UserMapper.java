package com.C2C.Mapper;

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
	 * @return �û���ʵ��
	 */
	User getUserByIdUser(int idUser);
	
}
