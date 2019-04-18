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
	
	/**
	 * ��һ�����Լ���ת��Ϊһ��json����
	 * @param leaveMessages ���Լ���
	 * @return һ��json�����ʽ���ַ���
	 */
	String leaveMessageToJson(List<GoodLeaveMessage> leaveMessages);
	
	/**
	 * ����һ����
	 * @param goodId �����Ե���Ʒ��id
	 * @param userId ���¸������Ե��û���id
	 * @param message ���Ե�����
	 * @return ���ͳɹ���true ����ʧ�ܣ�false
	 */
	boolean sendLeaveMessage(int goodId, int userId, String message);
	
}
