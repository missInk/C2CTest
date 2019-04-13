<%@page import="com.C2C.Config.AlipayConfig"%>
<%@page import="com.alipay.api.AlipayApiException"%>
<%@page import="com.alipay.api.response.AlipaySystemOauthTokenResponse"%>
<%@page import="com.alipay.api.request.AlipaySystemOauthTokenRequest"%>
<%@page import="com.alipay.api.DefaultAlipayClient"%>
<%@page import="com.alipay.api.AlipayClient"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
	AlipaySystemOauthTokenRequest req = new AlipaySystemOauthTokenRequest();
	String auth_code = (String)request.getParameter("auth_code");
	req.setCode(auth_code);
	req.setGrantType("authorization_code");
	try {
	    AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(req);
	    String tokn = oauthTokenResponse.getAccessToken();
	    request.setAttribute("tokn", tokn);
	    request.getRequestDispatcher("AlipayLoginServlet?method=getAlipayId").forward(request, response);
	} catch (AlipayApiException e) {
	    //处理异常
	    e.printStackTrace();
	}
%>