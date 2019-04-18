package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.GoodLeaveMessage;

public interface GoodLeaveMessageMapper {

	/**
	 * 通过商品的id来获取商品的评论
	 * @param goodId 商品的id
	 * @return 所有该商品评论的List集合
	 */
	List<GoodLeaveMessage> getGoodLeaveMessageByGoodId(int goodId);
	
	/**
	 * 将一个留言存入到数据库当中
	 * @param leaveMessage 留言的实体信息
	 * @return 发送成功：true 发送失败：false
	 */
	boolean sendLeaveMessage(@Param("leaveMessage")GoodLeaveMessage leaveMessage);
	
}
