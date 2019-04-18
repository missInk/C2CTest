package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyMapper {

	/**
	 * 通过回复的ID查询回复
	 * @param idProductMessageReply 回复的id
	 * @return 一个回复的实体类
	 */
	List<ProductMessageReply> getProductMessageReplyByMessageId(int idProductMessageReply);
	
	/**
	 * 获得某条留言回复的数量
	 * @param messageId 留言的id
	 * @return 回复的数量
	 */
	int getMessageReplyCount(int messageId);
	
	/**
	 * 发送一条留言的回复
	 * @param messageReply 一条留言回复的实体
	 * @return 发送成功true 发送失败：false
	 */
	boolean sendReply(@Param("messageReply")ProductMessageReply messageReply);
	
}
