package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.Message;

public interface MessageService {

	/**
	 * ���һ����Ϣ
	 * @param message һ������ӵ���Ϣ
	 */
	void addMessage(Message message);
	
	/**
	 * �����ݿ����һ����Ϣ
	 * @param getterId ��Ϣ����ߵ�id
	 * @param senderId ��Ϣ�����ߵ�id
	 * @param goodId ��Ʒ��id
	 * @param message ��Ϣ������
	 * @param state ��Ϣ��״̬ 0��δ�� 1���Ѷ�
	 */
	void addMessage(int getterId, int senderId, int goodId, String message, int state);
	
	/**
	 * �鿴��ǰ����Ϣ��¼
	 * @param getterId ��Ϣ����ߵ�id
	 * @param senderId ��Ϣ�����ߵ�id
	 * @param goodId ��Ʒ��id��������Ϊ�ж��Ƿ�Ϊͬһ�Ự����Ҫ��ʶ��
	 * @param star �鿴��Ϣ����ʵλ��
	 * @param size �鿴��ʷ��Ϣ������
	 * @return ����������List��Ϣ����
	 */
	List<Message> getMessage(int getterId, int senderId, int goodId, int star, int size);
	
	/**
	 * �����ʷ��Ϣ��¼������
	 * @param getterId ��Ϣ����ߵ�id
	 * @param senderId ��Ϣ�����ߵ�id
	 * @param goodId ��Ʒ��id
	 * @return ��ʷ��Ϣ��¼������
	 */
	int getHistoryMessageCount(int getterId, int senderId, int goodId);
	
	/**
	 * ��һ����Ϣ�ļ���ת��Ϊjson��ʽ���ַ���
	 * @param messages list���͵���Ϣ����
	 * @return json��ʽ���ַ���
	 */
	String messageToJson(List<Message> messages);
	
}
