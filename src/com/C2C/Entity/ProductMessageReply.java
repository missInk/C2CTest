package com.C2C.Entity;

public class ProductMessageReply {

	private int idProductMessageReply;
	private int messageId;
	private int replyUserId;
	private int beReplyUserId;
	private String reply;
	private String replyUserName;
	private String beReplyUserName;

	public int getIdProductMessageReply() {
		return idProductMessageReply;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public String getBeReplyUserName() {
		return beReplyUserName;
	}

	public void setBeReplyUserName(String beReplyUserName) {
		this.beReplyUserName = beReplyUserName;
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

	public int getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(int replyUserId) {
		this.replyUserId = replyUserId;
	}

	public int getBeReplyUserId() {
		return beReplyUserId;
	}

	public void setBeReplyUserId(int beReplyUserId) {
		this.beReplyUserId = beReplyUserId;
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
				+ ", replyUserId=" + replyUserId + ", beReplyUserId=" + beReplyUserId + ", reply=" + reply
				+ ", replyUserName=" + replyUserName + ", beReplyUserName=" + beReplyUserName + "]";
	}

}
