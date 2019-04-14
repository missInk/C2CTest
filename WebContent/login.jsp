<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
    String uuid = UUID.randomUUID().toString();
    session.setAttribute("uuidLogin", uuid);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/loginandregister.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/iconfont.css">
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/login.js"></script>
	
	<title>login</title>
</head>
<body>
<div>
    <form  action="${pageContext.request.contextPath }/UserServlet?method=login" method="POST" >
        <!--顶部 start-->;
        <div class="top">
            <div class="top-title">
                <!-- 放置赚赚标题 -->
                <img src="" alt="">赚赚
            </div> 
            <div class="top-image">
                <!-- 用户头像居中 -->
                <img src="" alt="" id="headPortrait" style="width: 100%;">
            </div>
        </div> 
        <!--顶部 end-->
        <!--信息填写部分 start-->
        <div class="main">
            <!--登陆详细信息 start-->
            <div class="login-info">
            	${loginError }
                <table>
                    <tr>
                        <td>
                            <i class="iconfont">&#xe64c;</i>
                            <input type="text" placeholder="邮箱" required  name="email" id="email">
                            <div id="signinError"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <i class="iconfont">&#xe614;</i>                             
                            <input type="password" placeholder="密码" required  name="passWord">
                        </td>
                    </tr>
                </table>
            </div>
            <!--登陆详细信息 end-->
        </div>
        <!--信息填写部分 end-->
        <!--底部 start-->
        <div class="bottom">
            <div class="bottom-buttom">
           	 	<input type="hidden" value="<%=uuid %>" name="uuidLogin">
                <input type="submit" value="登陆">
                <a href="${pageContext.request.contextPath }/register.jsp"><input value="注册"></a>
                <!-- <button>注册</button> -->
            </div>
            <div class="bottom-icon">
                <a href="AlipayLoginServlet?method=goAlipayLogin">使用支付宝快速登录</a>
            </div>
        </div>
        <!--底部 end-->     
    </form>
</div>

</body>
</html>