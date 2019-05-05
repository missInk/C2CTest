package com.C2C.Control;

import java.io.IOException;
import java.util.List;

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
	
	public String getGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String positionName = request.getParameter("positionName");
		String range = request.getParameter("range");
		int page = Integer.parseInt(request.getParameter("page"));
		String category = request.getParameter("category");
		List<Good> goods = goodService.getGoodsByPositionAndPage(positionName, range, page, category);
    	request.getSession().setAttribute("goods", goods);
    	int pageSize = goodService.getGoodPageSize(positionName, range, category);
    	request.getSession().setAttribute("pageSize", pageSize);
		return "index.jsp";
	}

}
