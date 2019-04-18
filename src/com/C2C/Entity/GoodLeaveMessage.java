package com.C2C.Entity;

public class GoodLeaveMessage {

	private int idgoodLeaveMessage;
	private int goodId;
	private User leaveUser;
	private String message;
	private int replyCount;
	private String leaveMessageDate;

	public GoodLeaveMessage() {
		super();
	}

	public GoodLeaveMessage(int goodId, User leaveUser, String message, String leaveMessageDate) {
		super();
		this.goodId = goodId;
		this.leaveUser = leaveUser;
		this.message = message;
		this.leaveMessageDate = leaveMessageDate;
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

	public User getLeaveUser() {
		return leaveUser;
	}

	public void setLeaveUser(User leaveUser) {
		this.leaveUser = leaveUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getLeaveMessageDate() {
		return leaveMessageDate;
	}

	public void setLeaveMessageDate(String leaveMessageDate) {
		this.leaveMessageDate = leaveMessageDate;
	}

	@Override
	public String toString() {
		return "GoodLeaveMessage [idgoodLeaveMessage=" + idgoodLeaveMessage + ", goodId=" + goodId + ", leaveUser=" + leaveUser + ", message=" + message + "]";
	}

}
