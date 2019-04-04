package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.Message;

public interface MessageService {

	/**
	 * 添加一条消息
	 * @param message 一条被添加的消息
	 */
	void addMessage(Message message);
	
	/**
	 * 
	 * @param message
	 * @param star
	 * @param size
	 * @return
	 */
	List<Message> getMessage(Message message, int star, int size);
}
