package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.GoodLeaveMessage;

public interface GoodLeaveMessageService {

	/**
	 * ͨ����Ʒ��id����ȡ��Ʒ������
	 * @param goodId ��Ʒ��id
	 * @return ���и���Ʒ���۵�List����
	 */
	List<GoodLeaveMessage> getGoodLeaveMessageByGoodId(int goodId);
	
}
