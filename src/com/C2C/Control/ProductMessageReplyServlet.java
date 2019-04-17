package com.C2C.Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Entity.ProductMessageReply;
import com.C2C.Service.ProductMessageReplyService;

@WebServlet("/ProductMessageReplyServlet")
public class ProductMessageReplyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ProductMessageReplyService messageReplyService;
	
	public void init() throws ServletException {
		super.init();
		messageReplyService = (ProductMessageReplyService)getApplicationcontext().getBean("productMessageReplyServiceImpl");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		List<ProductMessageReply> messageReplys = messageReplyService.getProductMessageReplyById(messageId);
		String messageReplysJson = messageReplyService.messageReplyToJson(messageReplys);
		response.getWriter().print(messageReplysJson);
	}
}
