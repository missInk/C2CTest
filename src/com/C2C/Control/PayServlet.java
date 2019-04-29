package com.C2C.Control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Config.AlipayConfigDev;
import com.C2C.Entity.Order;
import com.C2C.Service.Impl.PayServiceImpl;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeQueryRequest;

@WebServlet("/PayServlet")
public class PayServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private PayServiceImpl payServiceImpl;
	private AlipayClient alipayClient;
	
	@Override
	public void init() throws ServletException {
		super.init();
		payServiceImpl = (PayServiceImpl)getApplicationcontext().getBean("payServiceImpl");
		//��ó�ʼ����AlipayClient
		alipayClient = new DefaultAlipayClient(AlipayConfigDev.gatewayUrl, AlipayConfigDev.app_id, AlipayConfigDev.merchant_private_key, "json", AlipayConfigDev.charset, AlipayConfigDev.alipay_public_key, AlipayConfigDev.sign_type);
	}
	
	public String returnURI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AlipayApiException {
		//��ȡ֧�������͹�������Ϣ
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
				: valueStr + values[i] + ",";
			}
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		//����SDK��֤ǩ��
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfigDev.alipay_public_key, AlipayConfigDev.charset, AlipayConfigDev.sign_type);

		//�������������д���ĳ������´�������ο�������
		if(signVerified) {
			//�̻�������
			/*String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//֧�������׺�
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//������
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");*/
			return "paySuccess.jsp";
		}else {
			return "payFalse.jsp";
		}
	}
	
	public void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idgood = Integer.parseInt(request.getParameter("idgood"));
		Order order = payServiceImpl.newOrder(idgood);
		try {
			response.getWriter().println(payServiceImpl.pay(order));
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}
	
	public void querry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����������
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		//֧�������׺�
		String trade_no = new String(request.getParameter("idOrder").getBytes("ISO-8859-1"),"UTF-8");
		alipayRequest.setBizContent("{\"trade_no\":\""+ trade_no +"\"}");
		//����
		String result = null;
		try {
			result = alipayClient.execute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		//���
		response.getWriter().println(result);
	}
}
