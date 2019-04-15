<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String uuid = UUID.randomUUID().toString();
	session.setAttribute("uuidRegist", uuid);
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/loginandregister.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/iconfont.css">
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/regist.js"></script>
</head>
<body>

	<form action="${pageContext.request.contextPath }/UserServlet?method=regist" method="post">
        <!--顶部 start-->
        <div class="top">
            <div class="top-title">
                <!-- 放置赚赚标题 -->
                <img src="" alt="">赚赚注册界面
            </div> 
        </div> 
        <!--顶部 end-->
        <!--信息填写部分 start-->
        <div class="main">
            <!--注册详细信息 start-->
            <div class="register-info">
            	<div style="text-align: center;">${registerError }</div>
                <table>
                    <tr>
                        <td>
                            <i class="iconfont">&#xe64c;</i>
                            <input type="text"  placeholder="邮箱" name="email" id="email" required>
                            <div id="emailError"></div>
                        </td>
                    </tr>
                    <tr>                                         
                        <td>
                            <i class="iconfont">&#xe65a;</i>
                            <input type="text" placeholder="用户名" name="userName" id="userName" required>
                        </td>
                    </tr>
                        <td>
                            <i class="iconfont">&#xe614;</i>
                            <input type="password" placeholder="密码" required name="passWord" id="passWord">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <i class="iconfont">&#xe614;</i>
                            <input type="password" placeholder="确认密码" required name="repassWord" id="repassWord">
                            <div id="passWordError"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        	<div>
	                            <input type="text" placeholder="邮箱验证码" required name="ecode" id="ecode" style="width: 100px;">
	                            <input type="button" value="发送验证码" id="sendCode" style="width: 100px;font-size: 11px;">
	                            <div id="ecodeError">
                           	</div>
                        </td>
                    </tr>
                </table>
            </div>
            <!--注册详细信息 end-->
        </div>
        <!--信息填写部分 end-->
        <!--底部 start-->
        <div class="bottom">
            <div class="bottom-buttom">
                <input type="hidden" value="<%=uuid %>" name="uuidRegist">
                <input type="submit" value="注册">
                <a href="${pageContext.request.contextPath }/login.jsp"  class="help_a">老用户？点击登录</a>
            </div>
        </div>
        <!--底部 end-->     
    </form>

</body>
</html>