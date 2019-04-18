package com.C2C.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.GoodLeaveMessage;

public interface GoodLeaveMessageMapper {

	/**
	 * ͨ����Ʒ��id����ȡ��Ʒ������
	 * @param goodId ��Ʒ��id
	 * @return ���и���Ʒ���۵�List����
	 */
	List<GoodLeaveMessage> getGoodLeaveMessageByGoodId(int goodId);
	
	/**
	 * ��һ�����Դ��뵽���ݿ⵱��
	 * @param leaveMessage ���Ե�ʵ����Ϣ
	 * @return ���ͳɹ���true ����ʧ�ܣ�false
	 */
	boolean sendLeaveMessage(@Param("leaveMessage")GoodLeaveMessage leaveMessage);
	
}
