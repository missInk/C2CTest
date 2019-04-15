$(function(){
	$("#email").change(function(){
		var val = $(this).val();
		val = $.trim(val);
		if(val != ""){
			var url = "UserServlet?method=checkEmailStyle";
			var args = {"email":val};
			$.post(url,args,function(data){
				console.log(data);
				if(data == "邮箱格式不正确"){
					$("#emailError").text(data);
				}else{
					url = "UserServlet?method=checkEmailRegist";
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
			var url = "UserServlet?method=checkPassword";
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
			var url = "UserServlet?method=checkPassword";
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
			var url = "VerificationCodeServlet?method=checkCode";
			var args = {"email":email,"ecode":ecode};
			$.post(url,args,function(data){
				$("#ecodeError").text(data);
			})
		}
	})
	
	function setTimeout(){
		var time = 60;
		var timeid =window.setInterval(function(){
			time -= 1;
			$("#sendCode").attr("value",time + "s后可再次发送");
			if(time == 0){
				window.clearInterval(timeid);
				$("#sendCode").attr("value","再次发送验证码");
				$("#sendCode").attr('disabled',false);
			}
		}, 1000);
	}
	
	$("#sendCode").click(function(){
		$(this).attr('disabled',true);
		var email = $("#email").val();
		email = $.trim(email);
		if(email != ""){
			var url = "UserServlet?method=checkEmailStyle";
			var args = {"email":email};
			$.post(url,args,function(data){
				console.log(data);
				if(data == "邮箱格式不正确"){
					alert("发送失败：邮箱格式不正确");
					$("#sendCode").attr('disabled',false);
				}else{
					url = "UserServlet?method=checkEmailRegist";
					$.post(url,args,function(data){
						if(data == "邮箱已被注册"){
							alert("发送失败：邮箱已被注册");
							$("#sendCode").attr('disabled',false);
						}else{
							//执行ajax操作
							url = "VerificationCodeServlet?method=sendCode";
							$.post(url,args,function(data){
								$(this).attr("value","60s后再次发送");
								setTimeout();
							})
						}
					})
				}
			})
		}else{
			alert("发送失败：请输入邮箱");
			$("#sendCode").attr('disabled',false);
		}
	})
})