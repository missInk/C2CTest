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
		String reqUUID = request.getParameter("uuidLogin");
		String sessUUID = (String)request.getSession().getAttribute("uuidLogin");
		//令牌只能使用一次，所以使用完删除该令牌
		request.getSession().removeAttribute("uuidLogin");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = request.getParameter("email");
			String passWord = request.getParameter("passWord");
			UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
			if(userService.checkUser(email, passWord) != 0){
				Cookie cookie = userService.newCookie(email, passWord);
				response.addCookie(cookie);
				User user = userService.getUserInfo(email, passWord);
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
	
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUUID = request.getParameter("uuidRegist");
		String sessUUID = (String)request.getSession().getAttribute("uuidRegist");
		//令牌只能使用一次，所以使用完删除该令牌
		request.getSession().removeAttribute("uuidRegist");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
			String email = (String)request.getParameter("email");
			if(!userService.checkEmailStyle(email) || !userService.checkEmailRegist(email)) {
				//处理邮箱格式不正确，或已被注册的逻辑
			}
			String userName = (String)request.getParameter("userName");
			String passWord = (String)request.getParameter("passWord");
			String repassWord = (String)request.getParameter("repassWord");
			String ecode = (String)request.getParameter("ecode");
			if(userService.checkPassword(passWord, repassWord)) {
				if(userService.regist(email, userName, passWord, ecode)) {
					//处理注册成功逻辑
				}else {
					//处理注册失败逻辑
				}
			}
		}
		return "/regist.jsp";
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
