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
		//����ֻ��ʹ��һ�Σ�����ʹ����ɾ��������
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
	
	/**
	 * �����Ƿ��ظ��ύ
	 * @param reqUUID req����UUID��ֵ
	 * @param sessUUID sess����UUID��ֵ
	 * @return
	 */
	private boolean checkAgain(String reqUUID, String sessUUID) {
		if(reqUUID.equals(sessUUID)) {
			return true;
		}
		return false;
	}

}
