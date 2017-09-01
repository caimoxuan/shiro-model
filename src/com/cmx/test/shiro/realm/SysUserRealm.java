package com.cmx.test.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmx.test.entity.SysUsers;
import com.cmx.test.service.SysUsersService;

public class SysUserRealm extends AuthorizingRealm{
	
	@Autowired
	SysUsersService sysUsersService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		
		SysUsers sysUsers = sysUsersService.findUserByName(username);
		System.out.println("doGetAuthenticationInfo:" + sysUsers);
		if(sysUsers == null){
			throw new UnknownAccountException();
		}
		if(sysUsers.getLocked()){
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUsers.getUsername(),
				sysUsers.getPassword(),
				ByteSource.Util.bytes(sysUsers.getCredentialsSalt()),
				getName()
		);
		
		return authenticationInfo;
	}

}
