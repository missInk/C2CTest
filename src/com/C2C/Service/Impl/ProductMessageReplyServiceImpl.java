package com.C2C.Service.Impl;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;
import com.C2C.Entity.User;
import com.C2C.Mapper.ProductMessageReplyMapper;
import com.C2C.Service.ProductMessageReplyService;
import com.C2C.Util.DateUtil;

import net.sf.json.JSONArray;

public class ProductMessageReplyServiceImpl implements ProductMessageReplyService {

	private ProductMessageReplyMapper productMessageReplyMapper;
	
	public void setProductMessageReplyMapper(ProductMessageReplyMapper productMessageReplyMapper) {
		this.productMessageReplyMapper = productMessageReplyMapper;
	}
	
	@Override
	public List<ProductMessageReply> getProductMessageReplyById(int idProductMessageReply) {
		List<ProductMessageReply> messageReplys = productMessageReplyMapper.getProductMessageReplyByMessageId(idProductMessageReply);
		return messageReplys;
	}

	@Override
	public String messageReplyToJson(List<ProductMessageReply> messageReplys) {
		JSONArray jsonArray = JSONArray.fromObject(messageReplys);
		return jsonArray.toString();
	}

	@Override
	public boolean sendReply(int messageId, int replyUserId, int beReplyUserId, String reply) {
		String replyDate = DateUtil.getNowDate();
		User replyUser = new User(replyUserId);
		User beReplyUser = new User(beReplyUserId);
		ProductMessageReply messageReply = new ProductMessageReply(messageId, replyUser, beReplyUser, reply, replyDate);
		return productMessageReplyMapper.sendReply(messageReply);
	}

	@Override
	public int getReplyCount(int messageId) {
		return productMessageReplyMapper.getMessageReplyCount(messageId);
	}

}
