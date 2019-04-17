package com.C2C.Mapper;

import java.util.List;

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
	
}
