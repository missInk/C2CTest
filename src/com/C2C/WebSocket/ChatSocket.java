package com.C2C.WebSocket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.C2C.Entity.Message;

import net.sf.json.JSONObject;

@ServerEndpoint("/chatSocket/{idUser}")  
public class ChatSocket {

	private static int onlineCount = 0;  
    private static Map<Integer, ChatSocket> clients = new ConcurrentHashMap<Integer, ChatSocket>();  
    private Session session;  
    private Integer idUser;
    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
    @OnOpen
	public void onOpen(@PathParam("idUser") int idUser, Session session) throws IOException {  
		  
        this.idUser = idUser;
        this.session = session;  
          
        addOnlineCount();  
        clients.put(idUser, this);  
        System.out.println(idUser + "已连接");  
    }  
  
    @OnClose  
    public void onClose() throws IOException {  
    	System.out.println(idUser.toString()+"已断开连接");
        clients.remove(idUser);  
        subOnlineCount();  
    }  
  
    @OnMessage  
    public void onMessage(Session session, String msg) throws IOException {  
    	System.out.println(msg);
		JSONObject jsonTo = JSONObject.fromObject(msg);
		Message message = (Message)JSONObject.toBean(jsonTo, Message.class);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		message.setDate(dateFormat.format(date));
		sendMessageTo(message);
    }  
  
    @OnError  
    public void onError(Session session, Throwable error) {  
        error.printStackTrace();  
    }  
  
    public void sendMessageTo(Message message) throws IOException { 
    	int state = -1;
    	ChatSocket getterSocket = clients.get(message.getGetter());
    	if(getterSocket != null) {
    		getterSocket.session.getBasicRemote().sendText(message.getMessage());
        	state = 1;
    	}
        message.setState(state);
    }  
      
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
  
    public static synchronized void addOnlineCount() {  
    	ChatSocket.onlineCount++;  
    }  
  
    public static synchronized void subOnlineCount() {  
    	ChatSocket.onlineCount--;  
    }  
  
    public static synchronized Map<Integer, ChatSocket> getClients() {  
        return clients;  
    }  
	
}
