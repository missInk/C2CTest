package com.C2C.Entity;

public class User implements Cloneable{

	private int idUser;
	private String headPortrait;
	private String email;
	private String userName;
	private String passWord;
	private String sex;
	private String school;
	private String alipay;

	@Override
	public User clone() throws CloneNotSupportedException {
		return (User)super.clone();
	}
	
	public User() {
	}

	public User(int idUser) {
		this.idUser = idUser;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getAlipay() {
		return alipay;
	}

	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		 this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", headPortrait=" + headPortrait + ", email=" + email + ", userName="
				+ userName + ", passWord=" + passWord + ", sex=" + sex + ", school=" + school + "]";
	}

}
