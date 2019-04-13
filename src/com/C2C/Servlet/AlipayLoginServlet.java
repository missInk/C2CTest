package com.C2C.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Config.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayUserInfoShareResponse;

@WebServlet("/AlipayLoginServlet")
public class AlipayLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public void getAlipayId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		AlipayUserInfoShareRequest req = new AlipayUserInfoShareRequest();
	    String token = (String)request.getAttribute("tokn");
	    AlipayUserInfoShareResponse resp = null;
		try {
			resp = alipayClient.execute(req, token);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	 
	    if (resp.isSuccess()) {
	    	//处理调用成功逻辑
	        String userId = resp.getUserId();
	        System.out.println(userId);
	        response.sendRedirect(request.getContextPath() + "/index.jsp");
	    } else {
	    	//处理调用失败逻辑
	    	response.getWriter().println("登录失败："+resp.getSubMsg());
	    	System.out.println("来自支付宝的提示："+resp.getSubCode() + ":" + resp.getSubMsg());
	    } 
	}

	public void goAlipayLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+AlipayConfig.app_id+"&scope=auth_user&redirect_uri="+AlipayConfig.redirect_uri+"&state=init";
		response.sendRedirect(uri);
	}
	
}
