package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

public interface VerificationCodeMapper {

	/**
	 * 插入某个邮箱的验证码
	 * @param email 邮箱地址
	 * @param ecode 验证码
	 * @return 插入成功：true 插入失败：false
	 */
	boolean insertEcode(@Param("email")String email, @Param("ecode")String ecode);
	
	/**
	 * 检查某个邮箱的验证码是否正确
	 * @param email 邮箱地址
	 * @param ecode 用户输入的验证码
	 * @return 验证码正确：邮箱地址  验证码错误：null
	 */
	String checkEcode(@Param("email")String email, @Param("ecode")String ecode);
	
	/**
	 * 检查这个邮箱是否在之前就发送过验证码
	 * @param email 被检查的邮箱
	 * @return 发送过：email 没有发送过：null
	 */
	String checkEmail(String email);
	
	/**
	 * 更新某个邮箱的验证码
	 * @param email 被更新的邮箱
	 * @param ecode 新的验证码
	 * @return 成功：true 失败：false
	 */
	boolean updateEcode(@Param("email")String email, @Param("ecode")String ecode);
}
