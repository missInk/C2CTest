package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Message;

public interface MessageMapper {

	/**
	 * ���һ����Ϣ
	 * @param message һ������ӵ���Ϣ
	 */
	void addMessage(@Param("message")Message message);
	
	/**
	 * �鿴��ʷ��Ϣ��¼
	 * @param message �鿴��Ϣ��¼��������getterId senderId goodId
	 * @param star �鿴��Ϣ����ʼλ��
	 * @param size �鿴��Ϣ������
	 * @return ������������Ϣ����
	 */
	List<Message> getMessage(@Param("message")Message message, @Param("star")int star, @Param("size")int size);
	
	/**
	 * �鿴��ʷ��Ϣ��¼������
	 * @param message �鿴��Ϣ��¼��������getterId senderId goodId
	 * @return ��ʷ��Ϣ��¼������
	 */
	int getHistoryMessageCount(@Param("message")Message message);
}
