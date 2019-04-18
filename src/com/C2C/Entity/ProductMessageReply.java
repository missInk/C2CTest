package com.C2C.Entity;

public class ProductMessageReply {

	private int idProductMessageReply;
	private int messageId;
	private User replyUser;
	private User beReplyUser;
	private String reply;
	private String replyDate;

	public ProductMessageReply() {
		super();
	}

	public ProductMessageReply(int messageId, User replyUser, User beReplyUser, String reply, String replyDate) {
		super();
		this.messageId = messageId;
		this.replyUser = replyUser;
		this.beReplyUser = beReplyUser;
		this.reply = reply;
		this.replyDate = replyDate;
	}

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

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ProductMessageReply [idProductMessageReply=" + idProductMessageReply + ", messageId=" + messageId
				+ ", replyUser=" + replyUser + ", beReplyUser=" + beReplyUser + ", reply=" + reply + "]";
	}
}
