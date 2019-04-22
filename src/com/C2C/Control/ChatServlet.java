package com.C2C.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Entity.Good;
import com.C2C.Entity.Message;
import com.C2C.Entity.User;
import com.C2C.Service.GoodService;
import com.C2C.Service.MessageService;
import com.C2C.Service.UserService;

@WebServlet("/ChatServlet")
public class ChatServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private GoodService goodService;
	private MessageService messageService;
	
	public void init() throws ServletException {
		super.init();
		userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
		goodService = (GoodService)getApplicationcontext().getBean("goodServiceImpl");
		messageService = (MessageService)getApplicationcontext().getBean("messageServiceImpl");
	}
	
	public String getChatInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int goodId = Integer.parseInt(request.getParameter("goodId"));
		int getterId = Integer.parseInt(request.getParameter("getterId"));
		
		User getter = userService.getUserInfoByIdUser(getterId);
		User sender = (User) request.getSession().getAttribute("user");
		Good good = goodService.getGoodByIdGoods(goodId);
		
		if(getter != null && sender != null && good != null) {
			Message message = new Message(getter, sender, good);
			request.setAttribute("chatMessage", message);
		}else {
			response.getWriter().println("初始化聊天界面失败，无法获得完整的聊天信息参数");
		}
		return "chat.jsp";
	}
	
	public void getHistoryMessageCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer goodId = Integer.parseInt(request.getParameter("goodId"));
		Integer getterId = Integer.parseInt(request.getParameter("getterId"));
		User sender = (User) request.getSession().getAttribute("user");
		
		if(goodId != null && getterId != null && sender != null) {
			int historyMessageCount = messageService.getHistoryMessageCount(getterId, sender.getIdUser(), goodId);
			response.getWriter().print(historyMessageCount);
			return;
		}else {
			response.getWriter().print("参数不完整，无法获得消息记录的条数");
		}
	}
	
	public void getMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer goodId = Integer.parseInt(request.getParameter("goodId"));
		Integer getterId = Integer.parseInt(request.getParameter("getterId"));
		Integer star = Integer.parseInt(request.getParameter("star"));
		Integer size = Integer.parseInt(request.getParameter("size"));
		User sender = (User) request.getSession().getAttribute("user");
		
		if(goodId != null && getterId != null && sender != null && star != null && size != null) {
			List<Message> messages = messageService.getMessage(getterId, sender.getIdUser(), goodId, star, size);
			String jsonMessages = messageService.messageToJson(messages);
			response.getWriter().print(jsonMessages);
		}else {
			response.getWriter().print("参数不完整，无法获得历史消息记录");
		}
	}

}
