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
		//����ֻ��ʹ��һ�Σ�����ʹ����ɾ��������
		request.getSession().removeAttribute("uuidLogin");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = request.getParameter("email");
			String passWord = (String)request.getAttribute("passWord");
			
			if(userService.checkUser(email, passWord) != 0){
				Cookie cookie = userService.newCookie(email, passWord);
				response.addCookie(cookie);
				User user = userService.getUserInfo(email, passWord);
				request.getSession().setAttribute("user", user);
				System.out.println(email + "��¼�ɹ�");
				return "r:/index.jsp";
			}else {
				//�����¼ʧ���߼�
				request.setAttribute("loginError", "��������¼ʧ��");
				System.out.println(email + "��¼ʧ��");
			}
		}else {
			//�����ظ��ύ���߼�
			request.setAttribute("loginError", "�ظ��ύ��");
			System.out.println("�ظ��ύ��");
		}
		return "/login.jsp";
	}
	
	public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqUUID = request.getParameter("uuidRegist");
		String sessUUID = (String)request.getSession().getAttribute("uuidRegist");
		//����ֻ��ʹ��һ�Σ�����ʹ����ɾ��������
		request.getSession().removeAttribute("uuidRegist");
		if(reqUUID != null && checkAgain(reqUUID, sessUUID)) {
			String email = (String)request.getParameter("email");
			if(!userService.checkEmailStyle(email) || !userService.checkEmailRegist(email)) {
				//���������ʽ����ȷ�����ѱ�ע����߼�
				request.setAttribute("registerError", "�����ʽ���淶");
				return "/register.jsp";
			}
			String userName = (String)request.getParameter("userName");
			userName = new String(userName.getBytes("ISO-8859-1"), "utf-8");
			String passWord = (String)request.getAttribute("passWord");
			String repassWord = (String)request.getAttribute("repassWord");
			String ecode = (String)request.getParameter("ecode");
			if(userService.checkPassword(passWord, repassWord)) {
				if(userService.regist(email, userName, passWord, ecode)) {
					//����ע��ɹ��߼�
					Cookie cookie = userService.newCookie(email, passWord);
					response.addCookie(cookie);
					return "r:/index.jsp";
				}else {
					//����ע��ʧ���߼�
					request.setAttribute("registerError", "ע��ʧ��");
				}
			}else {
				request.setAttribute("registerError", "������������벻һ��");
			}
		}
		return "/register.jsp";
	}
	
	public void checkEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailRegist(email);
		if(result) {
			response.getWriter().println("û�и�����");
		}
	}
	
	public void checkEmailRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailRegist(email);
		if(!result) {
			response.getWriter().print("�����ѱ�ע��");
		}
	}
	
	public void checkEmailStyle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("email");
		boolean result = userService.checkEmailStyle(email);
		if(!result) {
			response.getWriter().print("�����ʽ����ȷ");
		}
	}
	
	public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passWord = (String)request.getParameter("passWord");
		String repassWord = (String)request.getParameter("repassWord");
		boolean result = userService.checkPassword(passWord, repassWord);
		if(!result) {
			response.getWriter().print("�������벻һ��");
		}
	}
	
	/**
	 * �����Ƿ��ظ��ύ
	 * @param reqUUID request����UUID��ֵ
	 * @param sessUUID session����UUID��ֵ
	 * @return �����ظ��ύ:true �ظ��ύ��false
	 */
	private boolean checkAgain(String reqUUID, String sessUUID) {
		if(reqUUID.equals(sessUUID)) {
			return true;
		}
		return false;
	}

}
