package com.C2C.Entity;

public class GoodLeaveMessage {

	private int idgoodLeaveMessage;
	private int goodId;
	private User leaveUser;
	private String message;
	private int replyCount;

	public int getreplyCount() {
		return replyCount;
	}

	public void setreplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public User getLeaveUser() {
		return leaveUser;
	}

	public void setLeaveUser(User leaveUser) {
		this.leaveUser = leaveUser;
	}

	public int getIdgoodLeaveMessage() {
		return idgoodLeaveMessage;
	}

	public void setIdgoodLeaveMessage(int idgoodLeaveMessage) {
		this.idgoodLeaveMessage = idgoodLeaveMessage;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GoodLeaveMessage [idgoodLeaveMessage=" + idgoodLeaveMessage + ", goodId=" + goodId + ", leaveUser=" + leaveUser + ", message=" + message + "]";
	}

}
