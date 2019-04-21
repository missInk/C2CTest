package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.User;

public interface UserMapper {

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
	
	/**
	 * 用户注册
	 * @param email 用户注册的邮箱
	 * @param userName 用户的用户名
	 * @param password 用户的密码
	 * @return 注册成功：1 注册失败：0
	 */
	int regist(@Param("email")String email, @Param("userName")String userName, @Param("passWord")String passWord);
	
	/**
	 * 检查某个邮箱是否已经被注册
	 * @param email 被检查的邮箱
	 * @return 被注册：该用户的idUser 没被注册：null
	 */
	Integer checkEmailRegist(String email);
	
	/**
	 * 通过阿里账号获取用户信息
	 * @param alipay 阿里账号
	 * @return 用户的部分信息
	 */
	User getUserByAlipay(String alipay);
	
	/**
	 * 绑定支付宝账号 
	 * @param email 被绑定的邮箱
	 * @param alipay 支付宝id
	 * @return 成功 true 失败false
	 */
	boolean binding(@Param("email")String email, @Param("alipay")String alipay);
	
	/**
	 * 获取头像
	 * @param email 被获取的账号的邮箱
	 * @return 头像地址
	 */
	String getHeadPortrait(String email);
	
}
