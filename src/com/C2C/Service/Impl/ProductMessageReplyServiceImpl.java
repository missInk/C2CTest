package com.C2C.Service.Impl;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;
import com.C2C.Mapper.ProductMessageReplyMapper;
import com.C2C.Service.ProductMessageReplyService;

public class ProductMessageReplyServiceImpl implements ProductMessageReplyService {

	private ProductMessageReplyMapper productMessageReplyMapper;
	
	public void setProductMessageReplyMapper(ProductMessageReplyMapper productMessageReplyMapper) {
		this.productMessageReplyMapper = productMessageReplyMapper;
	}
	
	@Override
	public List<ProductMessageReply> getProductMessageReplyById(int idProductMessageReply) {
		List<ProductMessageReply> messageReplys = productMessageReplyMapper.getProductMessageReplyByMessageId(1);
		return messageReplys;
	}

}
