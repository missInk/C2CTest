package com.C2C.WebSocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/TestSocket")
public class TestSocket {

	@OnOpen
	public void open(Session session) {
		System.out.println("id:" + session.getId());
	}

	@OnClose
	public void close(Session session) {
		System.out.println("id:" + session.getId() + "�ر���");
	}

	@OnMessage
	public void message(Session session, String msg) throws IOException {
		System.out.println("�ͻ��ˣ�" + msg);
		session.getBasicRemote().sendText("��ã�too");
	}

}
