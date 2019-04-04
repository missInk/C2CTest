package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.Message;

public interface MessageService {

	/**
	 * ���һ����Ϣ
	 * @param message һ������ӵ���Ϣ
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
