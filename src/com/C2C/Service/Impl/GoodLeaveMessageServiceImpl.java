package com.C2C.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.C2C.Entity.GoodLeaveMessage;
import com.C2C.Entity.User;
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

	@Override
	public boolean sendLeaveMessage(int goodId, int userId, String message) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String leaveMessageDate = dateFormat.format(date);
		User leaveUser = new User(userId);
		GoodLeaveMessage leaveMessage = new GoodLeaveMessage(goodId, leaveUser, message, leaveMessageDate);
		return goodLeaveMessageMapper.sendLeaveMessage(leaveMessage);
	}

}
