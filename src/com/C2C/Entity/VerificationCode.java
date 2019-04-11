package com.C2C.Entity;

/**
 * 验证码类，主要用来保存用户邮箱验证码的信息
 * @author lxx
 *
 */
public class VerificationCode {

	private String email;
	private String ecode;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

}
