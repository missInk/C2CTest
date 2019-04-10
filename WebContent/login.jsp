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
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/loginandregister.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/iconfont.css">
    <title>login</title>
    <style>
     @font-face {
  font-family: 'iconfont';
  src: url('iconfont.eot');
  src: url('iconfont.eot?#iefix') format('embedded-opentype'),
      url('iconfont.woff2') format('woff2'),
      url('iconfont.woff') format('woff'),
      url('iconfont.ttf') format('truetype'),
      url('iconfont.svg#iconfont') format('svg');
}
    </style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/preventDuplicateSub.js"></script>
</head>
<body>

<form action="${pageContext.request.contextPath }/UserServlet?method=login" method="POST" class="form">
        <div class="top">
               <div class="firstrow">
                   <div class="login">
                        <h2>登陆</h2>
                   </div>
                   <div class="register">
                        <h2><a href="../html/register.html">注册</a></h2>
                   </div>
               </div>    
        </div> 
         <hr>
        <div class="main">
            <table class="login">
               
                <tr>
                    <td>邮箱：</td>
                    <td>
                        <input type="text" name="email">
                    </td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="text" name="password"></td>
                </tr>
            </table>
        </div>
        <div class="bottom">
        		<input type="hidden" value="<%=uuid %>" name="uuidLogin">
                <input type="submit" value="登陆" class="submit">
        </div>
   </form>

</body>
</html>