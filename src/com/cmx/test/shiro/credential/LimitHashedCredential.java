package com.cmx.test.shiro.credential;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class LimitHashedCredential extends HashedCredentialsMatcher{
	
	private Cache<String, AtomicInteger> passwordRetryCache;
	
	public LimitHashedCredential(CacheManager cacheManager){
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}
	

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		System.out.println("doCredentialsMatch...");
		
		String username = (String)token.getPrincipal();
		
		AtomicInteger retryCount = passwordRetryCache.get(username);
		System.out.println(username +" 验证次数 :" + retryCount);
		if(retryCount == null){
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		
		if(retryCount.incrementAndGet() >= 5){
			throw new LockedAccountException();
		}

		boolean result = super.doCredentialsMatch(token, info);
		
		if(result){
			passwordRetryCache.remove(username);
		}
		
		return  result;
	}
	
	
	
	

}
