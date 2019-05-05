function changeTab(tabClassName, select) {
    var tab = document.getElementsByClassName(tabClassName)[0];
    var selects = document.getElementsByClassName("perform__bd__menu__list");
    for(var i = 0; i < selects.length; i++){
        selects[i].setAttribute('class','perform__bd__menu__list');
    }
    select.parentNode.setAttribute('class','perform__bd__menu__list selected');
    var tabs = document.getElementsByClassName('tab');
    for(var i = 0; i < tabs.length; i++){
        tabs[i].style.display = "none";
    }
    tab.style.display = "block";
}

function showLeaveMessage(idGoods, select) {
	getLeaveMessage(idGoods);
	changeTab('good_leave_message', select);
}

function getLeaveMessage(idGoods) {
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			var jsonData = JSON.parse(xmlhttp.responseText);
			let show_tag = jsonData.map(value =>
		    `
		    <div class="lessMessageContainer">
	            <div class="lm_author">
	                <div>
	                    <div class="author_img">
	                        <img src=${value.leaveUser.headPortrait }>
	                    </div>
	                </div>
	                <div>
	                    <div class="author_name">
	                        <span class="username">${value.leaveUser.userName }:</span>
	                    </div>
	                </div>
	            </div>
	            <div class="lm_content_main">
	                <div class="lm_content">
	                    <div class="lm_message">${value.message }</div>
	                    <div class="reply">
	                        <div class="reply_tail">
	                            <div class="reply_active">
	                                <a href="javaScript:void(0);" class="show_reply" id="show_reply_${value.idgoodLeaveMessage}" style="display: block;" onclick="showReply(${value.idgoodLeaveMessage})">回复(${value.replyCount})</a>
	                                <span class="fold_reply" id="fold_reply_${value.idgoodLeaveMessage}" onclick="foldReply(${value.idgoodLeaveMessage})" style="display: none">收起回复</span>
	                            </div>
	                            <div class="tail-wrap">
	                                <span class="tail-info">1楼</span>
	                                <span class="tail-info">${value.leaveMessageDate}</span>
	                            </div>
	                        </div>
	                        <!--此处插入评论-->
							<div class="reply_wrap" id="reply_wrap_${value.idgoodLeaveMessage}" style="display:none;">
								<div class="reply_content">
							        <ul class="reply_ul"  id="reply_${value.idgoodLeaveMessage}">
							            
							        </ul>
							        <ul class="reply_ul">
							            <li class="reply_li send_reply">
							                <a class="send_reply_a" href="javascript:void(0);">我也说一句</a>
							                <p>&nbsp;</p>
							            </li>
							            <li class="reply_li reply_to_reply_wrap">
							                <div class="reply_to_reply_val_wrap">
							                    <textarea class="reply_to_reply_val" id="reply_to_reply_val_${value.idgoodLeaveMessage}"></textarea>
							                </div>
							                <div class="send_r_r_val_wrap">
							                    <a href="javascript:void(0);" class="send_r_r_val" onclick="sendReply(${value.idgoodLeaveMessage}, '13', ${value.leaveUser.idUser})">发表</a>
							                </div>
							            </li>
							        </ul>
							    </div>
							</div>
	                    </div>
	                </div>
	            </div>
	        </div>
		    `
			).join("");
			document.getElementById("leaveMessage").innerHTML = show_tag;
		}
	}
	xmlhttp.open("GET","GoodLeaveMessageServlet?method=getLeaveMessage&idGoods="+idGoods,true);
	xmlhttp.send();
}

function foldReply(messageId){
	document.getElementById("reply_wrap_"+messageId).style.display = "none";
	document.getElementById("fold_reply_"+messageId).style.display = "none";
	document.getElementById("show_reply_"+messageId).style.display = "block";
}

function showReply(messageId){
	document.getElementById("reply_wrap_"+messageId).style.display = "block";
	document.getElementById("fold_reply_"+messageId).style.display = "block";
	document.getElementById("show_reply_"+messageId).style.display = "none";
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			var jsonData = JSON.parse(xmlhttp.responseText);
			let show_tag = jsonData.map(value =>
		    `
		            <li class="reply_li">
		                <div class="reply_user_img">
		                    <img src=${value.replyUser.headPortrait }>
		                </div>
		                <div class="reply_content_value">
		                    <span class="reply_username">${value.replyUser.userName }:</span>
		                    <span class="reply_text">${value.reply }</span>
		                    <div class="reply_time">
		                        <span>${value.replyDate }</span>
		                        <a class="reply_to_reply" href="javascript:void(0);">回复</a>
		                    </div>
		                </div>
		            </li>
		    `
			).join("");
			document.getElementById("reply_"+messageId).innerHTML = show_tag;
		}
	}
	xmlhttp.open("GET","ProductMessageReplyServlet?method=getReply&messageId="+messageId,true);
	xmlhttp.send();
}

function sendLeaveMessage(goodId, userId){
	if(goodId == "" || userId == ""){
		alert("参数不合法");
		return;
	}
	
	var message = document.getElementById("sendMessageValue").value;
	document.getElementById("sendMessageValue").value = "";
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			if(xmlhttp.responseText == 'true'){
				getLeaveMessage(goodId);
			}else{
				alert("留言发送失败");
			}
		}
	}
	xmlhttp.open("POST","GoodLeaveMessageServlet?method=sendLeaveMessage",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("goodId="+goodId+"&userId="+userId+"&message="+message);	
}

function sendReply(messageId, replyUserId, beReplyUserId){
	var reply = document.getElementById("reply_to_reply_val_"+messageId).value;
	document.getElementById("reply_to_reply_val_"+messageId).value = "";
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			if(xmlhttp.responseText == 'true'){
				setReplyCount(messageId);
				showReply(messageId);
			}else{
				alert("回复发送失败");
			}
		}
	}
	xmlhttp.open("POST","ProductMessageReplyServlet?method=sendReply",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("messageId="+messageId+"&replyUserId="+replyUserId+"&beReplyUserId="+beReplyUserId+"&reply="+reply);	
}

function setReplyCount(messageId){
	var xmlhttp;
	if (window.XMLHttpRequest){
		xmlhttp=new XMLHttpRequest();
	}else{
		 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("show_reply_"+messageId).innerHTML = "回复("+xmlhttp.responseText+")";
		}
	}
	xmlhttp.open("POST","ProductMessageReplyServlet?method=getReplyCount&messageId="+messageId,true);
	xmlhttp.send();	
}

function goChat(getterId, goodId){
	if(getterId != "" && goodId != ""){
		window.location.href = "http://li2453671898.yicp.io/C2CTest/ChatServlet?method=getChatInfo&goodId="+goodId+"&getterId="+getterId;
	}else{
		alert("参数不完整，无法连接到商家");
	}
}
