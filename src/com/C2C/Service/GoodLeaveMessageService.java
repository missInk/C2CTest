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
	
}
