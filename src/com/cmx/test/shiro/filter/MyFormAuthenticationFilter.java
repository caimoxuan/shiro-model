package com.cmx.test.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("onAccessDenied");
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		
		
		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		System.out.println("loginSuccess!");
		
		
		//((HttpServletResponse) response).sendRedirect("http://localhost:8080/shiro-model/login/home");
		return true;
	}

	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {
		System.out.println("failAttribute:"+ae.toString());
		System.out.println(getFailureKeyAttribute());
		super.setFailureAttribute(request, ae);
	}

	
	
	

}
