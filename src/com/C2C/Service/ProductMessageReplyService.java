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
	
	/**
	 * ����һ�����ԵĻظ�
	 * @param messageId ���Ե�id
	 * @param replyUserId �ظ��˵�id
	 * @param beReplyUserId ���ظ����˵�id
	 * @param reply �ظ�������
	 * @return ���ͳɹ�true ����ʧ�ܣ�false
	 */
	boolean sendReply(int messageId, int replyUserId, int beReplyUserId, String reply);
	
	/**
	 * ͨ�����Ե�id��ø������ԵĻظ���Ŀ
	 * @param messageId ���Ե�id
	 * @return �������ԵĻظ���Ŀ
	 */
	int getReplyCount(int messageId);
	
}
