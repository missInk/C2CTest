package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.GoodLeaveMessage;

public interface GoodLeaveMessageService {

	/**
	 * 通过商品的id来获取商品的评论
	 * @param goodId 商品的id
	 * @return 所有该商品评论的List集合
	 */
	List<GoodLeaveMessage> getGoodLeaveMessageByGoodId(int goodId);
	
	/**
	 * 将一个留言集合转化为一个json数组
	 * @param leaveMessages 留言集合
	 * @return 一个json数组格式的字符串
	 */
	String leaveMessageToJson(List<GoodLeaveMessage> leaveMessages);
	
	/**
	 * 发送一留言
	 * @param goodId 被留言的商品的id
	 * @param userId 留下该条留言的用户的id
	 * @param message 留言的内容
	 * @return 发送成功：true 发送失败：false
	 */
	boolean sendLeaveMessage(int goodId, int userId, String message);
	
}
