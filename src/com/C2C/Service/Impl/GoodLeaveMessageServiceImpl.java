package com.C2C.Service.Impl;

import java.util.List;

import com.C2C.Entity.GoodLeaveMessage;
import com.C2C.Entity.User;
import com.C2C.Mapper.GoodLeaveMessageMapper;
import com.C2C.Service.GoodLeaveMessageService;
import com.C2C.Util.DateUtil;

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

	@Override
	public boolean sendLeaveMessage(int goodId, int userId, String message) {
		String leaveMessageDate = DateUtil.getNowDate();
		User leaveUser = new User(userId);
		GoodLeaveMessage leaveMessage = new GoodLeaveMessage(goodId, leaveUser, message, leaveMessageDate);
		return goodLeaveMessageMapper.sendLeaveMessage(leaveMessage);
	}

}
