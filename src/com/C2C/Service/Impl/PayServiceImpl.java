package com.C2C.Service.Impl;

import com.C2C.Config.AlipayConfigDev;
import com.C2C.Entity.Good;
import com.C2C.Entity.Order;
import com.C2C.Mapper.OrderMapper;
import com.C2C.Service.PayService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

public class PayServiceImpl implements PayService {

	private OrderMapper orderMapper;
	
	public OrderMapper getOrderMapper() {
		return orderMapper;
	}

	public void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	@Override
	public void giveMoney() {

	}

	@Override
	public Order newOrder(int idGood) {
		Order order = new Order();
		Good good = orderMapper.getSimpleGood(idGood);
		order.setGood(good);
		order.setState(0);
		order.setAmount(String.valueOf(good.getPrice()));
		orderMapper.insert(order);
		return order;
	}

	@Override
	public String pay(Order order) throws AlipayApiException {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfigDev.gatewayUrl, AlipayConfigDev.app_id, AlipayConfigDev.merchant_private_key, "json", AlipayConfigDev.charset, AlipayConfigDev.alipay_public_key, AlipayConfigDev.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfigDev.return_url);
		alipayRequest.setNotifyUrl(AlipayConfigDev.notify_url);
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = String.valueOf(order.getidOrder());
		//付款金额，必填
		String total_amount =  String.valueOf(order.getAmount());
		//订单名称，必填	
		String subject = order.getGood().getGoodName();
		//商品描述，可空
		String body = "用于购买商品："+order.getGood().getGoodName();
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		return alipayClient.pageExecute(alipayRequest).getBody();
	}

}
