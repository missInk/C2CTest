package com.C2C.Control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Entity.Good;
import com.C2C.Service.GoodService;

@WebServlet("/GoodServlet")
public class GoodServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	private GoodService goodService;
	
	public void init() throws ServletException {
		super.init();
		goodService = (GoodService)getApplicationcontext().getBean("goodServiceImpl");
	}
	
	public String getGoodByIdGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idGoods = Integer.parseInt(request.getParameter("idGoods"));
		Good good = goodService.getGoodByIdGoods(idGoods);
		request.setAttribute("good", good);
		return "shoppingInfo.jsp";
	}

}
