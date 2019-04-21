<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绑定账号</title>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#email").change(function(){
	var val = $(this).val();
	val = $.trim(val);
	if(val != ""){
		var url = "UserServlet?method=checkEmail";
		var args = {"email":val};
		$.post(url,args,function(data){
			$("#emailError").text(data);
			})
		}
	})
	$("#submit").click(function(){
	var email = $("#email").val();
	email = $.trim(email);
	var passWord = $("#passWord").val();
	passWord = $.trim(passWord);
	var url = "UserServlet?method=binding";
	var args = {"email":email, "passWord":passWord, "alipay":"${alipay}"};
	$.post(url,args,function(data){
			if(data == "success"){
				window.location.href="${pageContext.request.contextPath }/index.jsp";
			}else{
				$("#bindingError").text(data);
			}
		})
	})
})
</script>
</head>
<body>
<h1>绑定账号</h1>
<div id="bindingError"></div>
被绑定账号的邮箱：<input type="text" id="email"><div id="emailError"></div><br>
被绑定账号的密码：<input type="password" id="passWord"><br>
<input type="button" value="绑定" id="submit"><br>
<a href="${pageContext.request.contextPath }/register.jsp">没有账号前去注册</a>


</body>
</html>