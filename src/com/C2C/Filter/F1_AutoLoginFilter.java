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

import com.C2C.Entity.User;
import com.C2C.Service.UserService;
import com.C2C.Service.Impl.UserServiceImpl;

@WebFilter(value="/index.jsp")
public class F1_AutoLoginFilter implements Filter {

	private ApplicationContext context;
	
    public void init(FilterConfig filterConfig) throws ServletException {
    	context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 处理过滤信息方法
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Object object = req.getSession().getAttribute("user");
        if (object == null) {
            Cookie[] cookies = req.getCookies();
            Cookie cookie = null;
            if (cookies != null && cookies.length > 0) {
                for (Cookie c : cookies) {
                    String name = c.getName();
                    if ("autoLogin".equals(name)) {
                        cookie = c;
                        break;
                    }
                }
            }
            if (cookie != null) {
                String[] split = cookie.getValue().split("&");
                String email = split[0];
                String password = split[1];
                UserService userService = (UserServiceImpl)context.getBean("userServiceImpl");
                if(userService.checkUser(email, password) != 0) {
                	User user = userService.getUserInfo(email, password);
                	req.getSession().setAttribute("user", user);
                }else {
                	cookie.setMaxAge(0);
                	resp.addCookie(cookie);
                }
            }
        }
        chain.doFilter(request, response);
    }
    
    public void destroy() {
    }

}
