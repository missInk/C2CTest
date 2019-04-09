package com.C2C.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Entity.User;
import com.C2C.Service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
		if(userService.checkUser(email, password) != 0){
			Cookie cookie = userService.newCookie(email, password);
			response.addCookie(cookie);
			User user = userService.getUserInfo(email, password);
			request.getSession().setAttribute("user", user);
			return "/index.jsp";
		}else {
			return "/login.html";
		}
	}
	
	

}
