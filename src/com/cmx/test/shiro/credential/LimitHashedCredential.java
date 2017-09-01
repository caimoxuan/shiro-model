package com.cmx.test.shiro.credential;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class LimitHashedCredential extends HashedCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		
		
		System.out.println("doCredentialsMatch...");
		
		
		return super.doCredentialsMatch(token, info);
	}
	
	
	

}
