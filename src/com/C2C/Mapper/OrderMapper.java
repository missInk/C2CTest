package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;
import com.C2C.Entity.Order;

public interface OrderMapper {

	/**
	 * �½�һ��������������Ʒ����Ϣע�뵽������
	 * @param idgood ������ID
	 * @return �½��Ķ���
	 */
	Good getSimpleGood(int idGood);
	
	int insert(@Param("order")Order order);
	
}
