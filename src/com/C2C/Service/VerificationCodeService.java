package com.C2C.Service;

public interface VerificationCodeService {

	/**
	 * 检查这个邮箱是否在之前就发送过验证码
	 * @param email 被检查的邮箱
	 * @return 发送过：true 没有发送过：false
	 */
	boolean checkEmail(String email);
	
	/**
	 * 检查某个邮箱的验证码是否正确
	 * @param email 邮箱地址
	 * @param ecode 用户输入的验证码
	 * @return 验证码正确：true 验证码错误：false
	 */
	boolean checkEcode(String email, String ecode);
	
	/**
	 * 更新某个邮箱的验证码
	 * @param email 被更新的邮箱
	 * @param ecode 新的验证码
	 * @return 成功：true 失败：false
	 */
	boolean updateEcode(String email, String ecode);
	
	/**
	 * 插入某个邮箱的验证码
	 * @param email 邮箱地址
	 * @param ecode 验证码
	 * @return 插入成功：true 插入失败：false
	 */
	boolean insertEcode(String email, String ecode);
	
	/**
	 * 发送邮箱验证码到指定邮箱
	 * @param email 邮箱地址
	 * @param ecode 验证码的内容
	 */
	void sendEamil(String email, String ecode);
	
}
