package com.C2C.Service;

import javax.servlet.http.Cookie;

import com.C2C.Entity.User;

public interface UserService {

	/**
	 * 检查用户是否合法
	 * @param email 用户的邮箱
	 * @param passWord 用户的密码 [会对密码进行MD5加密]
	 * @return 合法：用户的主键  不合法：null
	 */
	Integer checkUser(String email, String passWord);
	
	/**
	 * 根据用户的邮箱和密码返回用户的基本信息
	 * @param email 用户的邮箱
	 * @param passWord 用户的密码
	 * @return 用户的基本信息(用户ID，用户名，用户头像，用户性别，用户学校)
	 */
	User getUserInfo(String email, String passWord);
	
	/**
	 * 将用户的邮箱和密码保存到cookie中
	 * @param email 用户的邮箱
	 * @param passWord 用户的密码
	 * @return 保存用户邮箱和密码的cookie
	 */
	Cookie newCookie(String email, String passWord);
	
	/**
	 * 检查用户输入的邮箱输入格式是否正确
	 * @param email 用户输入的邮箱
	 * @return 格式正确：true 错误：false
	 */
	boolean checkEmailStyle(String email);
	
	/**
	 * 检查用户两次输入的密码是否一致
	 * @param password 第一次输入的密码
	 * @param repassword 重复输入的密码
	 * @return 两次输入的密码一致：true 两次输入的密码不一致：false
	 */
	boolean checkPassword(String passWord, String repassWord);
	
	/**
	 * 用户注册
	 * @param email 用户注册的邮箱
	 * @param userName 用户的用户名
	 * @param password 用户的密码 [会对密码进行MD5加密]
	 * @param ecode 邮箱验证码
	 * @return 注册成功：true 注册失败：false
	 */
	boolean regist(String email, String userName, String passWord, String ecode);
	
	/**
	 * 检查某个邮箱是否可以被注册
	 * @param email 被检查的邮箱
	 * @return 可以注册：true 不可注册：false
	 */
	boolean checkEmailRegist(String email);
	
	/**
	 * 通过阿里账号获取用户信息(邮箱 密码)
	 * @param alipay 阿里账号
	 * @return 用户的部分信息
	 */
	User getUserByAlipay(String alipay);
}
