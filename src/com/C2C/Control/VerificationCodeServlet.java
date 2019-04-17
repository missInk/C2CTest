package com.C2C.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.C2C.Service.VerificationCodeService;

@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private VerificationCodeService codeService;
	
	public void init() throws ServletException {
		super.init();
		codeService = (VerificationCodeService)getApplicationcontext().getBean("verificationCodeServiceImpl");
	}
	
	public void sendCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		codeService.sendCode(email);
	}
	
	public void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String ecode = request.getParameter("ecode");
		if(!codeService.checkEcode(email, ecode)) {
			response.getWriter().print("” œ‰—È÷§¬Î¥ÌŒÛ");
		}
	}

}
