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

import com.C2C.Entity.Position;

@WebFilter(value="/index.jsp")
public class F2_PositionFilter implements Filter  {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
		
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
            String range = split[1];
            Position position = new Position();
            position.setPositionName(positionName);
            position.setRange(range);
            req.getSession().setAttribute("position", position);
        }else {
        	Cookie positionCookie = new Cookie("position","南昌&江西农业大学");
        	positionCookie.setMaxAge(360000);
        	positionCookie.setPath(" /C2CTest/index.jsp");
    		resp.addCookie(positionCookie);
    		Position position = new Position();
            position.setPositionName("南昌");
            position.setRange("江西农业大学");
            req.getSession().setAttribute("position", position);
        }
        chain.doFilter(request, response);
    }
	
	public void init(FilterConfig arg0) throws ServletException {
	}

}
