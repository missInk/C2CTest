$(function(){
	$("#email").change(function(){
	var val = $(this).val();
	val = $.trim(val);
	if(val != ""){
		var url = "UserServlet?method=checkEmail";
		var args = {"email":val};
		$.post(url,args,function(data){
			if(data == ""){
				 url = "UserServlet?method=getheadPortrait";
				 $.post(url,args,function(data){
					 $("#headPortrait").attr("src",data);
				 })
			}else{
				$("#signinError").text(data);
			}
			})
		}
	})
})