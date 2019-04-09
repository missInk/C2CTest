package com.C2C.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebFilter(value="/index.jsp")
public class PositionFilter implements Filter  {

	private ApplicationContext context;
	
	@Override
	public void destroy() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("position".equals(name)) {
                    cookie = c;
                    break;
                }
            }
        }
        if (cookie != null) {
            String[] split = cookie.getValue().split("&");
            String positionName = split[0];
        }
        chain.doFilter(req, response);
    }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
