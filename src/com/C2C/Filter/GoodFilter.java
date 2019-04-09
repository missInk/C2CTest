package com.C2C.Filter;

import java.io.IOException;
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

import com.C2C.Service.GoodService;
import com.C2C.Service.Impl.GoodServiceImpl;

@WebFilter(value="/index.jsp")
public class GoodFilter implements Filter {

	private ApplicationContext context;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        Object object = req.getSession().getAttribute("user");
        if (object == null) {
        	GoodService goodService = (GoodServiceImpl)context.getBean("goodServiceImpl");
        	goodService.getGoodsByStore(idposition, range, category, minPrice, maxPrice, page, size)
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
