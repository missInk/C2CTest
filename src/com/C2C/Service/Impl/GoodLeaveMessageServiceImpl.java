package com.C2C.Service.Impl;

import java.util.List;

import com.C2C.Entity.GoodLeaveMessage;
import com.C2C.Mapper.GoodLeaveMessageMapper;
import com.C2C.Service.GoodLeaveMessageService;

import net.sf.json.JSONArray;

public class GoodLeaveMessageServiceImpl implements GoodLeaveMessageService {

	private GoodLeaveMessageMapper goodLeaveMessageMapper;
	
	public void setGoodLeaveMessageMapper(GoodLeaveMessageMapper goodLeaveMessageMapper) {
		this.goodLeaveMessageMapper = goodLeaveMessageMapper;
	}

	@Override
	public List<GoodLeaveMessage> getGoodLeaveMessageByGoodId(int goodId) {
		return goodLeaveMessageMapper.getGoodLeaveMessageByGoodId(goodId);
	}

	@Override
	public String leaveMessageToJson(List<GoodLeaveMessage> leaveMessages) {
		JSONArray array = JSONArray.fromObject(leaveMessages);
		return array.toString();
	}

}
