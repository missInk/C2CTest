package com.C2C.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.C2C.Util.MD5Util;

@WebFilter(value="/UserServlet")
public class PasswordFilter implements Filter {

    public PasswordFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 String passWord = req.getParameter("passWord");
		 String repassWord = req.getParameter("repassWord");
		 if(passWord != null) {
			 req.setAttribute("passWord", MD5Util.makeStringToMD5(passWord));
		 }
		 if(repassWord != null) {
			 req.setAttribute("repassWord", MD5Util.makeStringToMD5(repassWord));
		 }
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
