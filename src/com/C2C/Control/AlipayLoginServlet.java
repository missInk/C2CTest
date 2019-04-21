package com.C2C.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Config.AlipayConfig;
import com.C2C.Entity.User;
import com.C2C.Service.UserService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayUserInfoShareResponse;

@WebServlet("/AlipayLoginServlet")
public class AlipayLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AlipayClient alipayClient = null;   
	
	@Override
	public void init() throws ServletException {
		super.init();
		alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	}
	
	public void getAlipayId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlipayUserInfoShareRequest req = new AlipayUserInfoShareRequest();
	    String token = (String)request.getAttribute("tokn");
	    AlipayUserInfoShareResponse resp = null;
		try {
			resp = alipayClient.execute(req, token);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	 
	    if (resp.isSuccess()) {
	    	//������óɹ��߼�
	        String alipay = resp.getUserId();
	        UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
	        User user = userService.getUserByAlipay(alipay);
	        if(user != null) {
		        Cookie cookie = userService.newCookie(user.getEmail(), user.getPassWord());
		        response.addCookie(cookie);
		        response.sendRedirect(request.getContextPath() + "/index.jsp");
		        return;
	        }else {
	        	request.setAttribute("alipay", alipay);
	        	request.getRequestDispatcher("binding.jsp").forward(request, response);
	        	return;
	        }
	    } else {
	    	//�������ʧ���߼�
	    	response.getWriter().println("��¼ʧ�ܣ�"+resp.getSubMsg());
	    	System.out.println("����֧��������ʾ��"+resp.getSubCode() + ":" + resp.getSubMsg());
	    } 
	}

	public void goAlipayLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id="+AlipayConfig.app_id+"&scope=auth_user&redirect_uri="+AlipayConfig.redirect_uri+"&state=init";
		response.sendRedirect(uri);
	}
	
}
