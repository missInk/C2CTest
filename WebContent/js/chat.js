let historyMessageCount;
const size = 15;

function getSocket(getterId, senderId, goodId) {
	var target = "ws://li2453671898.yicp.io/C2CTest/chatSocket/"+senderId;
	console.log(target);
	 if ('WebSocket' in window) {
         ws = new WebSocket(target);
     } else if ('MozWebSocket' in window) {
         ws = new MozWebSocket(target);
     } else {
         alert('WebSocket is not supported by this browser.');
         return;
     }

	 ws.onmessage = function(event){
	 	console.log(event.data);
	 	var getMsgStr = 
		`
	 	<div class='getterMsg'>
           <div class='getterMsg-wrap'>
               <div class='getterMsg-box'>
                   <div class='getterMsg-box-val'> ${event.data }</div>
               </div>
           </div>
       </div>
		`;
	 	document.getElementById("messageWrap").innerHTML += getMsgStr;
	 }
}

function sendMsg(){
	var message = document.getElementById("msg");
	if(message.value.trim() == ""){
		return;
	}
	var msg = {
		"getter":{
			"idUser":getterId
		},
		"sender":{
			"idUser":senderId
		},
		"good":{
			"idGoods":goodId
		},
		"message":message.value
	}
	ws.send(JSON.stringify(msg));
	var sendMsgStr = 
	`
 	<div class="senderMsg">
        <div class="senderMsg-wrap">
            <div class="senderMsg-box">
                <div class="senderMsg-box-val"> ${msg.message }</div>
            </div>
        </div>
    </div>
	`
 	document.getElementById("messageWrap").innerHTML += sendMsgStr;
	message.value = "";
}

/**
 * 在文本框中输入回车时，将消息发送出去
 */
function keyDownSendMsg(event){
	changebtnStyle();
	if(event.keyCode!=13){
        return;
    }else{//当按键输入为回车时，执行下列操作
    	if (window.event) {
	      window.event.returnValue = false;
	    } else {
	      e.preventDefault(); //for firefox
	    }
        sendMsg();
        document.getElementById("sendBtn").classList.remove("act");
    }
}

function changebtnStyle(){
	var sendBtn = document.getElementById("sendBtn");
	var message = document.getElementById("msg");
	if(message.value.trim() == ""){
		sendBtn.classList.remove("act");
	}else{
		sendBtn.classList.add("act");
	}
}

function getHistoryCount(goodId, getterId){
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
			var result = xmlhttp.responseText;
			if(isNotANumber(result)){
				historyMessageCount = parseInt(result);
			}else{
				console.log(result);
			}
		}
	}
	xmlhttp.open("GET","ChatServlet?method=getHistoryMessageCount&goodId="+goodId+"&getterId="+getterId,true);
	xmlhttp.send();
}

function isNotANumber(inputData) {
	if(parseFloat(inputData).toString() == "NaN"){
		return false;
	}else{
		return true;
	}
}

function getHistoryMessage(goodId, getterId){
	if(historyMessageCount == 0){
		alert("已经显示所有历史消息记录了");
	}
	historyMessageCount = historyMessageCount-size > 0 ? historyMessageCount-size : 0;
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
			var historyMsgStr = jsonData.map(val => {
				if(val.getter.idUser == getterId){
					return `
					<div class="senderMsg">
				        <div class="senderMsg-wrap">
				            <div class="senderMsg-box">
				                <div class="senderMsg-box-val"> ${val.message }</div>
				            </div>
				        </div>
				    </div>
					`;
				}else{
					return `
				    <div class='getterMsg'>
			           <div class='getterMsg-wrap'>
			               <div class='getterMsg-box'>
			                   <div class='getterMsg-box-val'> ${val.message }</div>
			               </div>
			           </div>
			       </div>
					`;
				}
			}).join("");
			let messageHtml = document.getElementById("messageWrap").innerHTML;
			document.getElementById("messageWrap").innerHTML = historyMsgStr + messageHtml;
		}
	}
	xmlhttp.open("GET","ChatServlet?method=getMessage&goodId="+goodId+"&getterId="+getterId+"&star="+historyMessageCount+"&size="+size,true);
	xmlhttp.send();
}


