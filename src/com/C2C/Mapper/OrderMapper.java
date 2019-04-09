package com.C2C.Mapper;

import org.apache.ibatis.annotations.Param;

import com.C2C.Entity.Good;
import com.C2C.Entity.Order;

public interface OrderMapper {

	/**
	 * 新建一个订单，并将商品的信息注入到订单中
	 * @param idgood 订单的ID
	 * @return 新建的订单
	 */
	Good getSimpleGood(int idGood);
	
	int insert(@Param("order")Order order);
	
}
