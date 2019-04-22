package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Message;

public interface MessageMapper {

	/**
	 * 添加一条消息
	 * @param message 一条被添加的消息
	 */
	void addMessage(@Param("message")Message message);
	
	/**
	 * 查看历史消息记录
	 * @param message 查看消息记录的条件：getterId senderId goodId
	 * @param star 查看消息的起始位置
	 * @param size 查看消息的条数
	 * @return 符合条件的消息集合
	 */
	List<Message> getMessage(@Param("message")Message message, @Param("star")int star, @Param("size")int size);
	
	/**
	 * 查看历史消息记录的条数
	 * @param message 查看消息记录的条件：getterId senderId goodId
	 * @return 历史消息记录的条数
	 */
	int getHistoryMessageCount(@Param("message")Message message);
}
