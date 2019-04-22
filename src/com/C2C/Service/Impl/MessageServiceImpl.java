package com.C2C.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.C2C.Entity.Good;
import com.C2C.Entity.Message;
import com.C2C.Entity.User;
import com.C2C.Mapper.MessageMapper;
import com.C2C.Service.MessageService;

import net.sf.json.JSONArray;

public class MessageServiceImpl implements MessageService {

	private MessageMapper messageMapper;
	
	public void setMessageMapper(MessageMapper messageMapper) {
		this.messageMapper = messageMapper;
	}

	@Override
	public void addMessage(int getterId, int senderId, int goodId, String message, int state) {
		Good good = new Good(goodId);
		User getter = new User(getterId);
		User sender = new User(senderId);
		Message msg = new Message(getter, sender, message, state, good);
		addMessage(msg);
	}

	@Override
	public List<Message> getMessage(int getterId, int senderId, int goodId, int star, int size) {
		Message message = getMessage(getterId, senderId, goodId);
		List<Message> oldMessage = messageMapper.getMessage(message, star, size);
		return oldMessage;
	}

	/**
	 * 获得当前字符串格式的时间
	 * @return 字符串格式的时间
	 */
	private String getSendTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sendTime = dateFormat.format(date);
		return sendTime;
	}
	
	private Message getMessage(int getterId, int senderId, int goodId) {
		Good good = new Good(goodId);
		User getter = new User(getterId);
		User sender = new User(senderId);
		Message message = new Message(getter, sender, good);
		return message;
	}
	
	@Override
	public void addMessage(Message message) {
		String sendTime = getSendTime();
		message.setSendTime(sendTime);
		messageMapper.addMessage(message);
	}

	@Override
	public int getHistoryMessageCount(int getterId, int senderId, int goodId) {
		Message message = getMessage(getterId, senderId, goodId);
		return messageMapper.getHistoryMessageCount(message);
	}

	@Override
	public String messageToJson(List<Message> messages) {
		JSONArray jsonArray = JSONArray.fromObject(messages);
		return jsonArray.toString();
	}
	
}
