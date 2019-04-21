package com.C2C.Service.Impl;

import java.util.List;

import com.C2C.Entity.Message;
import com.C2C.Mapper.MessageMapper;
import com.C2C.Service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageMapper messageMapper;
	
	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	@Override
	public void addMessage(Message message) {

	}

	@Override
	public List<Message> getMessage(Message message, int star, int size) {
		return null;
	}

}
