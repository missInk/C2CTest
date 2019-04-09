package com.C2C.Service;

import com.C2C.Entity.Order;
import com.alipay.api.AlipayApiException;

public interface PayService {

	String pay(Order order) throws AlipayApiException;
	
	void giveMoney();
	
	Order newOrder(int idGood);
	
}
