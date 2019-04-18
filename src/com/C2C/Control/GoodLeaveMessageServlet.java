package com.C2C.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Entity.GoodLeaveMessage;
import com.C2C.Service.GoodLeaveMessageService;

@WebServlet("/GoodLeaveMessageServlet")
public class GoodLeaveMessageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private GoodLeaveMessageService goodLeaveMessageService;
	
	public void init() throws ServletException {
		super.init();
		goodLeaveMessageService = (GoodLeaveMessageService)getApplicationcontext().getBean("goodLeaveMessageServiceImpl");
	}
	
	public void getLeaveMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idGoods = Integer.parseInt(request.getParameter("idGoods"));
		List<GoodLeaveMessage> leaveMessages = goodLeaveMessageService.getGoodLeaveMessageByGoodId(idGoods);
		String leaveMessagesJson = goodLeaveMessageService.leaveMessageToJson(leaveMessages);
		response.getWriter().print(leaveMessagesJson);
	}
	
	public void sendLeaveMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String message = request.getParameter("message");
		boolean result = goodLeaveMessageService.sendLeaveMessage(goodId, userId, message);
		response.getWriter().print(result);
	}
	
}
