package com.C2C.Mapper;

import com.C2C.Entity.User;

public interface UserMapper {

	/**
	 * 通过用户的id来获取用户的的用户名
	 * @param idUser 用户的id
	 * @return 用户的的用户名
	 */
	String getUserNameByIduser(int idUser);
	
	/**
	 * 通过用户的id来获得用户的实体
	 * @param idUser 用户的id
	 * @return 用户的实体
	 */
	User getUserByIdUser(int idUser);
	
}
