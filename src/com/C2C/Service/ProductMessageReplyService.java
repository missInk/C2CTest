package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyService {

	/**
	 * 通过回复的ID查询回复
	 * @param idProductMessageReply 回复的id
	 * @return 一个回复的集合
	 */
	List<ProductMessageReply> getProductMessageReplyById(int idProductMessageReply);
	
	/**
	 * 将一个回复的集合转换为json数组
	 * @param messageReplys 回复的集合
	 * @return 回复的集合转换成的json数组
	 */
	String messageReplyToJson(List<ProductMessageReply> messageReplys);
	
}
