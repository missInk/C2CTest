package com.C2C.Service;

import java.util.List;

import com.C2C.Entity.ProductMessageReply;

public interface ProductMessageReplyService {

	/**
	 * ͨ���ظ���ID��ѯ�ظ�
	 * @param idProductMessageReply �ظ���id
	 * @return һ���ظ���ʵ����
	 */
	List<ProductMessageReply> getProductMessageReplyById(int idProductMessageReply);
	
}
