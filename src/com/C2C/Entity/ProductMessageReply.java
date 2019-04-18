package com.C2C.Entity;

public class ProductMessageReply {

	private int idProductMessageReply;
	private int messageId;
	private User replyUser;
	private User beReplyUser;
	private String reply;

	public int getIdProductMessageReply() {
		return idProductMessageReply;
	}

	public User getReplyUser() {
		return replyUser;
	}

	public void setReplyUser(User replyUser) {
		this.replyUser = replyUser;
	}

	public User getBeReplyUser() {
		return beReplyUser;
	}

	public void setBeReplyUser(User beReplyUser) {
		this.beReplyUser = beReplyUser;
	}

	public void setIdProductMessageReply(int idProductMessageReply) {
		this.idProductMessageReply = idProductMessageReply;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "ProductMessageReply [idProductMessageReply=" + idProductMessageReply + ", messageId=" + messageId
				+ ", replyUser=" + replyUser + ", beReplyUser=" + beReplyUser + ", reply=" + reply + "]";
	}
}
