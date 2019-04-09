package com.C2C.Entity;

public class User {

	private int idUser;
	private String headPortrait;
	private String email;
	private String userName;
	private String passWord;
	private String sex;
	private String school;
	private Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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

	public String getschool() {
		return school;
	}

	public void setschool(String school) {
		this.school = school;
	}


	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", headPortrait=" + headPortrait + ", email=" + email + ", userName="
				+ userName + ", passWord=" + passWord + ", sex=" + sex + ", school=" + school + ", store=" + store
				+ "]";
	}

	
}
