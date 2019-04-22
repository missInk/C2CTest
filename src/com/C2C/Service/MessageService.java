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
	 * 向数据库添加一条消息
	 * @param getterId 消息获得者的id
	 * @param senderId 消息发送者的id
	 * @param goodId 商品的id
	 * @param message 消息的内容
	 * @param state 消息的状态 0：未读 1：已读
	 */
	void addMessage(int getterId, int senderId, int goodId, String message, int state);
	
	/**
	 * 查看以前的消息记录
	 * @param getterId 消息获得者的id
	 * @param senderId 消息发送者的id
	 * @param goodId 商品的id（用来作为判断是否为同一会话的重要标识）
	 * @param star 查看消息的其实位置
	 * @param size 查看历史消息的条数
	 * @return 符合条件的List消息集合
	 */
	List<Message> getMessage(int getterId, int senderId, int goodId, int star, int size);
	
	/**
	 * 获得历史消息记录的条数
	 * @param getterId 消息获得者的id
	 * @param senderId 消息发送者的id
	 * @param goodId 商品的id
	 * @return 历史消息记录的条数
	 */
	int getHistoryMessageCount(int getterId, int senderId, int goodId);
	
	/**
	 * 将一个消息的集合转化为json格式的字符串
	 * @param messages list类型的消息集合
	 * @return json格式的字符串
	 */
	String messageToJson(List<Message> messages);
	
}
