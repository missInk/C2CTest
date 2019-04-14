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

	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#email").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			if(val != ""){
				var url = "${pageContext.request.contextPath }/UserServlet?method=checkEmailStyle";
				var args = {"email":val};
				$.post(url,args,function(data){
					console.log(data);
					if(data == "邮箱格式不正确"){
						$("#emailError").text(data);
					}else{
						url = "${pageContext.request.contextPath }/UserServlet?method=checkEmailRegist";
						$.post(url,args,function(data){
							$("#emailError").text(data);
						})
					}
				})
			}
		})
		
		$("#passWord").change(function(){
			var passWord = $(this).val();
			passWord = $.trim(passWord);
			var repassWord = $("#repassWord").val();
			repassWord = $.trim(repassWord);
			if(repassWord != "" && passWord != ""){
				var url = "${pageContext.request.contextPath }/UserServlet?method=checkPassword";
				var args = {"passWord":passWord,"repassWord":repassWord};
				$.post(url,args,function(data){
					$("#passWordError").text(data);
				})
			}
		})
		
		$("#repassWord").change(function(){
			var repassWord = $(this).val();
			repassWord = $.trim(repassWord);
			if(repassWord != ""){
				var url = "${pageContext.request.contextPath }/UserServlet?method=checkPassword";
				var args = {"passWord":$("#passWord").val(),"repassWord":repassWord};
				$.post(url,args,function(data){
					$("#passWordError").text(data);
				})
			}
		})
		
		$("#ecode").change(function(){
			var email = $("#email").val();
			email = $.trim(email);
			var ecode = $(this).val();
			ecode = $.trim(ecode);
			if(ecode != ""){
				var url = "${pageContext.request.contextPath }/VerificationCodeServlet?method=checkCode";
				var args = {"email":email,"ecode":ecode};
				$.post(url,args,function(data){
					$("#ecodeError").text(data);
				})
			}
		})
		
		$("#sendCode").click(function(){
			var email = $("#email").val();
			email = $.trim(email);
			if(email != ""){
				var url = "${pageContext.request.contextPath }/UserServlet?method=checkEmailStyle";
				var args = {"email":email};
				$.post(url,args,function(data){
					console.log(data);
					if(data == "邮箱格式不正确"){
						alert("邮箱格式不正确");
					}else{
						url = "${pageContext.request.contextPath }/UserServlet?method=checkEmailRegist";
						$.post(url,args,function(data){
							if(data == "邮箱已被注册"){
								alert("邮箱已被注册");
							}else{
								url = "${pageContext.request.contextPath }/VerificationCodeServlet?method=sendCode";
								$.post(url,args,function(data){
									alert("验证码发送成功");
								})
							}
						})
					}
				})
			}
		})
	})
	</script>


</head>
<body>
${registerError }
<form action="${pageContext.request.contextPath }/UserServlet?method=regist" method="post">
邮箱：<input name="email" id="email"><div id="emailError"></div><br>
用户名：<input name="userName" id="userName"><br>
密码：<input name="passWord" id="passWord"><br>
重复密码：<input name="repassWord" id="repassWord"><div id="passWordError"></div><br>
邮箱验证码：<input name="ecode" id="ecode"><input type="button" value="发送验证码" id="sendCode"><div id="ecodeError"></div><br>
<input type="hidden" value="<%=uuid %>" name="uuidRegist">
<input type="submit">
</form>

</body>
</html>