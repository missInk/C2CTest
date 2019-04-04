package com.C2C.Entity;

public class Message {

	private int idMessage;
	private int getter;
	private int sender;
	private String message;
	private int state;
	private String date;
	private int goodId;

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public int getGetter() {
		return getter;
	}

	public void setGetter(int getter) {
		this.getter = getter;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", getter=" + getter + ", sender=" + sender + ", message=" + message
				+ ", state=" + state + ", date=" + date + "]";
	}

}
