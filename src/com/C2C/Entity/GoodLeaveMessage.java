package com.C2C.Entity;

import java.util.List;

public class GoodLeaveMessage {

	private int idgoodLeaveMessage;
	private int goodId;
	private int leaveUserId;
	private User leaveUser;
	private String message;
	private List<ProductMessageReply> replys;

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

	public int getLeaveUserId() {
		return leaveUserId;
	}

	public void setLeaveUserId(int leaveUserId) {
		this.leaveUserId = leaveUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ProductMessageReply> getReplys() {
		return replys;
	}

	public void setReplys(List<ProductMessageReply> replys) {
		this.replys = replys;
	}

	@Override
	public String toString() {
		return "GoodLeaveMessage [idgoodLeaveMessage=" + idgoodLeaveMessage + ", goodId=" + goodId + ", leaveUserId="
				+ leaveUserId + ", leaveUser=" + leaveUser + ", message=" + message + ", replys=" + replys + "]";
	}

}
