package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

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
	 * @return 用户的实体(用户ID，用户名，用户头像，用户性别，用户学校)
	 */
	User getUserByIdUser(int idUser);
	
	/**
	 * 通过用户id来获得用户的简单信息
	 * @param idUser 用户id
	 * @return 用户的简单信息（用户名，用户头像）
	 */
	User getUserInfo(int idUser);
	
	/**
	 * 检查用户是否合法
	 * @param email 用户的邮箱
	 * @param password 用户的密码
	 * @return 合法：用户的主键  不合法：null
	 */
	Integer checkUser(@Param("email")String email, @Param("password")String password);
	
}
