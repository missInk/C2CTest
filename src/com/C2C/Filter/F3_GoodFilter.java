package com.C2C.Filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.C2C.Entity.Good;
import com.C2C.Entity.Position;
import com.C2C.Service.GoodService;
import com.C2C.Service.Impl.GoodServiceImpl;

@WebFilter(value="/index.jsp")
public class F3_GoodFilter implements Filter {

	private ApplicationContext context;
	private GoodService goodService;
	
	public void destroy() {
	}

	/**
	 * 若用户不为空，地点不为空，且当前页数为空时，执行该方法，获得第一页的商品信息，并保存到session域当中
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Object user = req.getSession().getAttribute("user");
        Position position = (Position)req.getSession().getAttribute("position");
        Object page = req.getParameter("page");
        if (user != null && position != null && page == null) {
        	List<Good> goods = goodService.getGoodsByPositionAndPage(position.getPositionName(), position.getRange(), 1, null);
        	req.getSession().setAttribute("goods", goods);
        }
        int pageSize = goodService.getGoodPageSize(position.getPositionName(), position.getRange(), null);
    	req.getSession().setAttribute("pageSize", pageSize);
        chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		goodService = (GoodServiceImpl)context.getBean("goodServiceImpl");
	}

}
