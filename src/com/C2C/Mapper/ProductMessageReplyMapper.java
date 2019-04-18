package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyMapper {

	/**
	 * ͨ���ظ���ID��ѯ�ظ�
	 * @param idProductMessageReply �ظ���id
	 * @return һ���ظ���ʵ����
	 */
	List<ProductMessageReply> getProductMessageReplyByMessageId(int idProductMessageReply);
	
	/**
	 * ���ĳ�����Իظ�������
	 * @param messageId ���Ե�id
	 * @return �ظ�������
	 */
	int getMessageReplyCount(int messageId);
	
	/**
	 * ����һ�����ԵĻظ�
	 * @param messageReply һ�����Իظ���ʵ��
	 * @return ���ͳɹ�true ����ʧ�ܣ�false
	 */
	boolean sendReply(@Param("messageReply")ProductMessageReply messageReply);
	
}
