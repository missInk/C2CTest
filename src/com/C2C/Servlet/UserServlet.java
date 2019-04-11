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
		//����ֻ��ʹ��һ�Σ�����ʹ����ɾ��������
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
				System.out.println(email + "��¼�ɹ�");
				return "r:/index.jsp";
			}else {
				//�����¼ʧ���߼�
				System.out.println(email + "��¼ʧ��");
			}
		}else {
			//�����ظ��ύ���߼�
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
			UserService userService = (UserService)getApplicationcontext().getBean("userServiceImpl");
			String email = (String)request.getParameter("email");
			if(!userService.checkEmailStyle(email) || !userService.checkEmailRegist(email)) {
				//���������ʽ����ȷ�����ѱ�ע����߼�
			}
			String userName = (String)request.getParameter("userName");
			String passWord = (String)request.getParameter("passWord");
			String repassWord = (String)request.getParameter("repassWord");
			String ecode = (String)request.getParameter("ecode");
			if(userService.checkPassword(passWord, repassWord)) {
				if(userService.regist(email, userName, passWord, ecode)) {
					//����ע��ɹ��߼�
				}else {
					//����ע��ʧ���߼�
				}
			}
		}
		return "/regist.jsp";
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
