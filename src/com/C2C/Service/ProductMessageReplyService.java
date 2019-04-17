package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyService {

	/**
	 * ͨ���ظ���ID��ѯ�ظ�
	 * @param idProductMessageReply �ظ���id
	 * @return һ���ظ��ļ���
	 */
	List<ProductMessageReply> getProductMessageReplyById(int idProductMessageReply);
	
	/**
	 * ��һ���ظ��ļ���ת��Ϊjson����
	 * @param messageReplys �ظ��ļ���
	 * @return �ظ��ļ���ת���ɵ�json����
	 */
	String messageReplyToJson(List<ProductMessageReply> messageReplys);
	
}
