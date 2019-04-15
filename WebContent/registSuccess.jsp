<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功</title>
<script type="text/javascript">

window.onload = function(){
	var times = Number.parseInt(document.getElementById("time").innerHTML);
	var timeid = window.setInterval(function(){autoGo()},1000);

	function autoGo(){
		times -= 1;
		document.getElementById("time").innerHTML = times;
		if(times == 0){
			window.clearInterval(timeid);
			window.location.href="${pageContext.request.contextPath }/index.jsp";
		}
	}
}

</script>
</head>
<body>

<h1>注册成功</h1>
恭喜你注册成功，<span id="time">10</span>s后自动跳转到主页

</body>
</html>