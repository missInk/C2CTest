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
       
	private UserService userService;
	
	public void init() throws ServletException {
		super.init();
		userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUUID = request.getParameter("uuidLogin");
		String sessUUID = (String)request.getSession().getAttribute("uuidLogin");
		//令牌只能使用一次，所以使用完删除该令牌
		request.getSession().removeAttribute("uuidLogin");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = request.getParameter("email");
			String passWord = (String)request.getAttribute("passWord");
			
			if(userService.checkUser(email, passWord) != 0){
				Cookie cookie = userService.newCookie(email, passWord);
				response.addCookie(cookie);
				User user = userService.getUserInfo(email, passWord);
				request.getSession().setAttribute("user", user);
				System.out.println(email + "登录成功");
				return "r:/index.jsp";
			}else {
				//处理登录失败逻辑
				request.setAttribute("loginError", "密码错误登录失败");
				System.out.println(email + "登录失败");
			}
		}else {
			//处理重复提交表单逻辑
			request.setAttribute("loginError", "重复提交表单");
			System.out.println("重复提交表单");
		}
		return "/login.jsp";
	}
	
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUUID = request.getParameter("uuidRegist");
		String sessUUID = (String)request.getSession().getAttribute("uuidRegist");
		//令牌只能使用一次，所以使用完删除该令牌
		request.getSession().removeAttribute("uuidRegist");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = (String)request.getParameter("email");
			if(!userService.checkEmailStyle(email) || !userService.checkEmailRegist(email)) {
				//处理邮箱格式不正确，或已被注册的逻辑
				request.setAttribute("registerError", "邮箱格式不规范");
				return "/register.jsp";
			}
			String userName = (String)request.getParameter("userName");
			userName = new String(userName.getBytes("ISO-8859-1"), "utf-8");
			String passWord = (String)request.getAttribute("passWord");
			String repassWord = (String)request.getAttribute("repassWord");
			String ecode = (String)request.getParameter("ecode");
			if(userService.checkPassword(passWord, repassWord)) {
				if(userService.regist(email, userName, passWord, ecode)) {
					//处理注册成功逻辑
					Cookie cookie = userService.newCookie(email, passWord);
					response.addCookie(cookie);
					return "r:/index.jsp";
				}else {
					//处理注册失败逻辑
					request.setAttribute("registerError", "注册失败");
				}
			}else {
				request.setAttribute("registerError", "两次输入的密码不一致");
			}
		}
		return "/register.jsp";
	}
	
	public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailRegist(email);
		if(result) {
			response.getWriter().println("没有该邮箱");
		}
	}
	
	public void checkEmailRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailRegist(email);
		if(!result) {
			response.getWriter().print("邮箱已被注册");
		}
	}
	
	public void checkEmailStyle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailStyle(email);
		if(!result) {
			response.getWriter().print("邮箱格式不正确");
		}
	}
	
	public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passWord = (String)request.getParameter("passWord");
		String repassWord = (String)request.getParameter("repassWord");
		boolean result = userService.checkPassword(passWord, repassWord);
		if(!result) {
			response.getWriter().print("两次密码不一致");
		}
	}
	
	/**
	 * 检查表单是否重复提交
	 * @param reqUUID request域中UUID的值
	 * @param sessUUID session域中UUID的值
	 * @return 不是重复提交:true 重复提交：false
	 */
	private boolean checkAgain(String reqUUID, String sessUUID) {
		if(reqUUID.equals(sessUUID)) {
			return true;
		}
		return false;
	}

}
