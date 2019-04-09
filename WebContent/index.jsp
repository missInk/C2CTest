<%@page import="com.C2C.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="top">
       <div class="tl">
           <span>
                <h1>赚赚</h1>
           </span>
       </div>
       <div class="tr">
            <span>
                <a href="./login.html">登陆</a>
            </span>
            <span>
                <a href="./login.html">取消</a>
            </span>
       </div>
    </div>
    <%
    if(session.getAttribute("user") != null){
    	User user = (User)session.getAttribute("user");
    	out.println(" 用户ID："+user.getIdUser());
    	out.println(" 用户名："+user.getUserName());
    	out.println(" 性别："+user.getSex());
    	out.println(" 学校："+user.getschool());
    	out.println(" 头像："+user.getHeadPortrait());
    }
    %>
    <div class="main"></div>
    <div class="bottom"></div>
    <div class="footer"></div>
</body>
</html>