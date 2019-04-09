package com.C2C.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Config.AlipayConfig;
import com.C2C.Entity.Order;
import com.C2C.Service.Impl.PayServiceImpl;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;

@WebServlet("/PayServlet")
public class PayServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("");
		
	}
	
	public void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idgood = Integer.parseInt(request.getParameter("idgood"));
		PayServiceImpl payServiceImpl = (PayServiceImpl)getApplicationcontext().getBean("payServiceImpl");
		Order order = payServiceImpl.newOrder(idgood);
		try {
			response.getWriter().println(payServiceImpl.pay(order));
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	public void payToMerchant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void querry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		
		//支付宝交易号
		String trade_no = new String(request.getParameter("idOrder").getBytes("ISO-8859-1"),"UTF-8");
		
		alipayRequest.setBizContent("{\"trade_no\":\""+ trade_no +"\"}");
		
		//请求
		String result = null;
		try {
			result = alipayClient.execute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		
		//输出
		response.getWriter().println(result);
	}
}
