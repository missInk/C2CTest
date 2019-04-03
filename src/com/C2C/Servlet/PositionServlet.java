package com.C2C.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Service.PositionService;
import com.C2C.Service.Impl.PositionServiceImpl;

@WebServlet("/PositionServlet")
public class PositionServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ȡ���еĵص㣬��ͨ��json��ʽ���ظ�ԭ��ҳ
	 */
	public void getAllPositions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PositionService positionService = (PositionServiceImpl)this.getApplicationcontext().getBean("positionServiceImpl");
		response.getWriter().print(positionService.getStorePositions());
	}
	
}
