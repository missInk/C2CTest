package com.C2C.Service;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;

public interface UserService {

	/**
	 * 检查用户是否合法
	 * @param email 用户的邮箱
	 * @param password 用户的密码
	 * @return 合法：用户的主键  不合法：null
	 */
	Integer checkUser(String email, String password);
	
	/**
	 * 根据用户的邮箱和密码返回用户的基本信息
	 * @param email 用户的邮箱
	 * @param password 用户的密码
	 * @return 用户的基本信息
	 */
	User getUserInfo(String email, String password);
	
	/**
	 * 将用户的邮箱和密码保存到cookie中
	 * @param email 用户的邮箱
	 * @param password 用户的密码
	 * @return 保存用户邮箱和密码的cookie
	 */
	Cookie newCookie(String email, String password);
}
