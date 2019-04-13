<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<form action="UserServlet?method=regist">
邮箱：<input name="email"><br>
用户名：<input name="userName"><br>
密码：<input name="passWord"><br>
重复密码：<input name="repassWord"><br>
邮箱验证码：<input name="ecode"><input type="button" value="发送验证码"><br>
<input type="submit">
</form>

</body>
</html>