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
			console.log(jsonData);
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
	                        <span class="username">${value.leaveUser.userName }</span>
	                    </div>
	                </div>
	            </div>
	            <div class="lm_content_main">
	                <div class="lm_content">
	                    <div class="lm_message">${value.message }</div>
	                    <div class="reply">
	                        <div class="reply_tail">
	                            <div class="reply_active">
	                                <a href="" class="show_reply" style="display: block;" onclick="shoeReply(${value.idgoodLeaveMessage})">回复(${value.replyCount})</a>
	                                <span class="fold_reply" style="display: none">收起回复</span>
	                            </div>
	                            <div class="tail-wrap">
	                                <span class="tail-info">1楼</span>
	                                <span class="tail-info">2019-4-16&nbsp;21:15</span>
	                            </div>
	                        </div>
	                        <!--此处插入评论-->
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

function shoeReply(messageId){
	
}

/*
 
 <div class="reply_wrap">
    <div class="reply_content">
        <ul class="reply_ul">
            <li class="reply_li">
                <div class="reply_user_img">
                    <img src="headPortrait/head.jpg">
                </div>
                <div class="reply_content_value">
                    <span class="reply_username">XXX:</span>
                    <span class="reply_text">这是一条测试用的回复</span>
                    <div class="reply_time">
                        <span>2019-4-16&nbsp;23:07</span>
                        <a class="reply_to_reply" href="javascript:void(0);">回复</a>
                    </div>
                </div>
            </li>
            
            <li class="reply_li send_reply">
                <a class="send_reply_a" href="javascript:void(0);">我也说一句</a>
                <p>&nbsp;</p>
            </li>
            <li class="reply_li reply_to_reply_wrap">
                <div class="reply_to_reply_val_wrap">
                    <textarea class="reply_to_reply_val"></textarea>
                </div>
                <div class="send_r_r_val_wrap">
                    <a href="javascript:void(0);" class="send_r_r_val">发表</a>
                </div>
            </li>
        </ul>
    </div>
</div>
  
 */



