package com.C2C.Mapper;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyMapper {

	/**
	 * 通过回复的ID查询回复
	 * @param idProductMessageReply 回复的id
	 * @return 一个回复的实体类
	 */
	List<ProductMessageReply> getProductMessageReplyByMessageId(int idProductMessageReply);
	
}
