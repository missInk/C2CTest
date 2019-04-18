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
	
	/**
	 * 发送一条留言的回复
	 * @param messageId 留言的id
	 * @param replyUserId 回复人的id
	 * @param beReplyUserId 被回复的人的id
	 * @param reply 回复的内容
	 * @return 发送成功true 发送失败：false
	 */
	boolean sendReply(int messageId, int replyUserId, int beReplyUserId, String reply);
	
	/**
	 * 通过留言的id获得该条留言的回复数目
	 * @param messageId 留言的id
	 * @return 该条留言的回复数目
	 */
	int getReplyCount(int messageId);
	
}
