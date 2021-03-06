package com.C2C.Entity;

public class Message {

	private int idMessage;
	private User getter;
	private User sender;
	private String message;
	private int state;
	private String sendTime;
	private Good good;

	public Message() {
		super();
	}

	public Message(User getter, User sender, Good good) {
		super();
		this.getter = getter;
		this.sender = sender;
		this.good = good;
	}

	public Message(User getter, User sender, String message, int state, Good good) {
		super();
		this.getter = getter;
		this.sender = sender;
		this.message = message;
		this.state = state;
		this.good = good;
	}

	public Message(User getter, User sender, String message, int state, String sendTime, Good good) {
		super();
		this.getter = getter;
		this.sender = sender;
		this.message = message;
		this.state = state;
		this.sendTime = sendTime;
		this.good = good;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public User getGetter() {
		return getter;
	}

	public void setGetter(User getter) {
		this.getter = getter;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", getter=" + getter + ", sender=" + sender + ", message=" + message
				+ ", state=" + state + ", sendTime=" + sendTime + ", good=" + good + "]";
	}

}
