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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String reqUUID = request.getParameter("uuidLogin");
		String sessUUID = (String)request.getSession().getAttribute("uuidLogin");
		//令牌只能使用一次，所以使用完删除该令牌
		request.getSession().removeAttribute("uuidLogin");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
			if(userService.checkUser(email, password) != 0){
				Cookie cookie = userService.newCookie(email, password);
				response.addCookie(cookie);
				User user = userService.getUserInfo(email, password);
				request.getSession().setAttribute("user", user);
				System.out.println(email + "登录成功");
				return "r:/index.jsp";
			}else {
				//处理登录失败逻辑
				System.out.println(email + "登录失败");
			}
		}else {
			//处理重复提交表单逻辑
			System.out.println("重复提交表单");
		}
		return "/login.jsp";
	}
	
	/**
	 * 检查表单是否重复提交
	 * @param reqUUID req域中UUID的值
	 * @param sessUUID sess域中UUID的值
	 * @return
	 */
	private boolean checkAgain(String reqUUID, String sessUUID) {
		if(reqUUID.equals(sessUUID)) {
			return true;
		}
		return false;
	}

}
