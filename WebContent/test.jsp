<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

var ws;
var target = "ws://localhost:8080/C2CTest/TestSocket";

function subOpen(){
	 if ('WebSocket' in window) {
         ws = new WebSocket(target);
     } else if ('MozWebSocket' in window) {
         ws = new MozWebSocket(target);
     } else {
         alert('WebSocket is not supported by this browser.');
         return;
     }

	 ws.onmessage = function(event){
	 	console.info(event.data);
	 }
}

function sendMsg(){
	var msg = document.getElementById("msg");
	ws.send(msg.value);
	msg.val = "";
}


</script>

</head>
<body>

<button onclick="subOpen();">建立链接</button>

<input id="msg">
<button onclick="sendMsg()">发送数据</button>














<!-- 
1、与服务器打开管道，获取之前的聊天记录
2、获得发送消息和接收消息的人的id
3、获取发送消息的内容
4、将这些消息，打包成一个json数据发送给java
5、服务器接收消息，将消息转为java对象，
6、服务器来搜索接收人的管道：找到了就将消息通过该管道将消息发送给接收者,存入数据库中,状态设置为1，没有找到将状态设置为0，存入数据库
7、客户端监听服务器发来的消息，接收完成后，将它显示在页面上
8、用户在登录的时候，发送一个异步的数据给服务器，来显示有多少条未接收到的信息
 -->

<!-- <div class="chatRoom">
	<div>
		<span>1</span>
	</div>
	<div class="chatValue">
		<textarea rows="30" cols="50"></textarea>
	</div>
	<div class="chat">
		<form action="">
			<input>
			<input type="submit">
		</form>		
	</div>
</div>

<div id="message">

</div>

<script type="text/javascript">

var websocket = null;  
var idUser = "123";  
  
//判断当前浏览器是否支持WebSocket  
if ('WebSocket' in window) {  
    websocket = new WebSocket("ws://" + document.location.host + "/C2CTest/chatSocket/" + idUser+"?iduser=1");  
} else {  
    alert('当前浏览器 Not support websocket')  
}  
  
//连接发生错误的回调方法  
websocket.onerror = function() {  
    setMessageInnerHTML("WebSocket连接发生错误");  
};  
  
//连接成功建立的回调方法  
websocket.onopen = function() {  
    setMessageInnerHTML("WebSocket连接成功");  
}  
  
//接收到消息的回调方法  
websocket.onmessage = function(event) {  
    setMessageInnerHTML(event.data);  
}  
  
//连接关闭的回调方法  
websocket.onclose = function() {  
    setMessageInnerHTML("WebSocket连接关闭");  
}  
  
//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。  
window.onbeforeunload = function() {  
    closeWebSocket();  
}  
  
//关闭WebSocket连接  
function closeWebSocket() {  
    websocket.close();  
}  

function setMessageInnerHTML(val){
	var message = document.getElementById("message");
	message.InnerHTML = val;
}

</script> -->



</body>
</html>