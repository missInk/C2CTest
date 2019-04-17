package com.C2C.Control;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BaseServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationcontext = null;
	
	public ApplicationContext getApplicationcontext() {
		return applicationcontext;
	}

	@Override
	public void init() throws ServletException {
		applicationcontext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String methodName = request.getParameter("method");
		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("û�д���method�������޷�ȷ����Ҫ���õķ���");
		}
		Class<? extends BaseServlet> c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("��Ҫ���õķ���" + methodName + "������");
		}
		try {
			String result = (String) method.invoke(this, request, response);
			/*
			 * ���ݷ����ķ���ֵ��������ת���ض��� û�з���ֵ�򷵻�ֵΪ�գ���������κδ��� �鿴����ֵ�Ƿ����ð�ţ����û�б�ʾת��
			 * �еĻ�����ð��ǰ���ǡ�r����R�����ʾ�ض��� ��ð��ǰ���ǡ�f����F�����ʾת�� ð�ź���Ϊ�ض������ת���ĵ�ַ ��������������׳��쳣
			 */
			if (result == null || result.trim().isEmpty()) {
				return;
			}
			if (result.contains(":")) {
				int index = result.indexOf(":");
				String e = result.substring(0, index);
				String path = result.substring(index + 1);
				if (e.equalsIgnoreCase("r")) {
					response.sendRedirect(request.getContextPath() + path);
				} else if (e.equalsIgnoreCase("f")) {
					request.getRequestDispatcher(path).forward(request, response);
				} else {
					throw new RuntimeException("��ָ���Ĳ����޷����");
				}
			} else {
				request.getRequestDispatcher(result).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
