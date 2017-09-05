package com.cmx.test.shiro.cache;

import java.io.Serializable;


import org.apache.shiro.session.Session;
//import org.apache.shiro.session.UnknownSessionException;
//import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;//如果继承这个的话，不会频繁读取session

public class MySessionDao extends CachingSessionDAO{
	
	private Session session;
	
	@Override
	protected void doDelete(Session session) {
		System.out.println("doDelete Session!");
	}

	@Override
	protected void doUpdate(Session session) {
		System.out.println("doUpdata Session " + session.getId());
	}
	
	
	@Override
	protected Serializable doCreate(Session session) {
		System.out.println("doCreate Session" + session.getId());
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		
		this.session = session;
		System.out.println(session.getId());
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable serializable) {
		System.out.println("doReadSession！！！！！！！！！！"+serializable.toString());
		//继承AbstractSessionDao时  shiro设计为每一个请求都需要读取session，包括静态资源，页面请求，就导致了请求一个多请求的页面，频繁读取session，超时session还会抛出UnknowSessionException
		//判断是否是静态资源，如果是静态资源，放弃读取session，如果是视图资源，放弃读取session
		
		
		return  session;
	}
	
	/*
	@Override
	public void delete(Session arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Session arg0) throws UnknownSessionException {
		// TODO Auto-generated method stub
		
	}
	*/
}
