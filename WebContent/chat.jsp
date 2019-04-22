<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	if(request.getAttribute("chatMessage") == null){
%>
<script type="text/javascript">
	alert("初始化聊天界面失败，无法获得完整的聊天信息参数");
</script>	
<%
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- setStyle start -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/tit-tail.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/commons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/chat.css">
<!-- setStyle end -->
<script src="${pageContext.request.contextPath }/js/tit.js"></script>
<script src="${pageContext.request.contextPath }/js/chat.js"></script>
<title>聊天界面</title>
</head>
<body>

<%@include file="tit.jsp" %>

<!-- 聊天界面开始 -->
<div class="chat-star">
    <div class="chat-header">
        <div class="chat-header-wrap">
            <div class="chat-header-box">
                <a href="javaScript:void(0);" class="chat-header-log">赚赚</a>
                <span class="border"></span>
                <a href="javaScript:void(0);" class="chat-header-tit">聊天服务</a>
            </div>
        </div>
    </div>
    <!-- 聊天主界面开始 -->
    <div class="chat-main">
        <div class="chat-main-wrap">
            <div class="chat-main-header">
                <div class="chat-main-header-wrap">
                    <div class="getter-img">
                        <div class="getter-img-box">
                            <img src=${chatMessage.getter.headPortrait }>
                        </div>
                    </div>
                    <div class="getter-userName">
                        <span>${chatMessage.getter.userName }</span>
                    </div>
                    <div class="goodName">
                        <div>${chatMessage.good.goodName }</div>
                    </div>
                </div>
            </div>
            <div class="chat-main-body">
                <!-- 消息记录面板开始 -->
                <div class="chatPanel">
                    <div class="show-oldMsg">
                        <div  class="show-oldMsg-box">
                            <span>点击查看历史消息</span>
                        </div>
                    </div>
                    <div id="messageWrap"></div>
                   </div>
                <!-- 消息记录面板结束 -->
                <div class="chat-footer">
                    <!-- 发送消息开始 -->
                    <div class="send-message">
                        <div class="send-message-val-box">
                            <textarea class="send-message-val" id="msg" cols="0"></textarea>
                        </div>
                        <button class="send-message-btn" id="sendBtn" onclick="sendMsg()">发送</button>
                    </div>
                    <!-- 发送消息结束 -->
                </div>
            </div>
        </div>
    </div>
    <!-- 聊天主界面结束 -->
</div>
<!-- 聊天界面结束 -->

<%@include file="tail.jsp" %>

<script type="text/javascript">
document.getElementById("msg").addEventListener("keydown",keyDownSendMsg);
var ws;
var getterId = ${chatMessage.getter.idUser };
var senderId = ${chatMessage.sender.idUser };
var goodId = ${chatMessage.good.idGoods };
getSocket(getterId, senderId, goodId);
</script>

</body>
</html>