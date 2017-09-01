package com.cmx.test.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model){
		
		String failureExceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if (failureExceptionClassName != null) {
			String error = null;
            if (AuthenticationException.class.getName()
                       .equalsIgnoreCase(failureExceptionClassName)) {
                error = "认证失败";
            } else if (IncorrectCredentialsException.class.getName().equalsIgnoreCase(
					failureExceptionClassName)) {
				error = "用户名/密码错误";
			} else if (UnknownAccountException.class.getName()
					.equalsIgnoreCase(failureExceptionClassName)) {
				error = "未知账户";
			} else if (UnknownSessionException.class.getName()
					.equalsIgnoreCase(failureExceptionClassName)) {
				error = "session 超时，请重新登录";
			} else if (LockedAccountException.class.getName()
					.equalsIgnoreCase(failureExceptionClassName)) {
				error = "账号被锁定";
			} else {
				error = "其他错误";
			}
            System.out.println(error);
			model.addAttribute("error", error);
            
		}
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			return "/home/home";
		}
		
		return "/login/login";
	} 
	
	@RequestMapping("dologin")
	public String dologin(HttpServletRequest request, HttpServletResponse response, Model model){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("user: "+username + "" + password);
		UsernamePasswordToken token = new UsernamePasswordToken(username,  
                password); 
		Subject subject = SecurityUtils.getSubject();
		try{
			subject.login(token);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "/login/login";
	}
	
	@RequestMapping("/home")
	public String home(){
		System.out.println("home");
		return "/home/home";
	}

}
