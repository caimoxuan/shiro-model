package com.cmx.test.junit;

import java.util.List;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cmx.test.entity.SysUsers;
import com.cmx.test.service.SysUsersService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import junit.framework.TestCase;

public class Test extends TestCase{
	
	private ApplicationContext applocation;
	
	@Before
	public void setUp(){
		System.out.println("init");
		applocation = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	
	
	public void testQueryUser(){
		SysUsersService sus = (SysUsersService) applocation.getBean("sysUsersService");
		try {
			List<SysUsers> query = sus.query(new SysUsers());
			System.out.println(query.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testAddUser(){
		SysUsers su = new SysUsers("cmx","123456");
		SysUsersService sus = (SysUsersService) applocation.getBean("sysUsersService");
		
		SysUsers addUser = sus.addUser(su);
		System.out.println(addUser+"添加成功");
		
	}
	
	public void testLogin(){
		SecurityManager sm = (SecurityManager)applocation.getBean("securityManager");
		SecurityUtils.setSecurityManager(sm);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("cmx",  
                "123456");  
		subject.login(token);
		
		System.out.println(subject.isAuthenticated());
	}
	
}
