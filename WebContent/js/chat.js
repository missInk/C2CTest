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