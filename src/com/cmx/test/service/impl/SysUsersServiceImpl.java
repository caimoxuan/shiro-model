package com.cmx.test.service.impl;

import org.springframework.stereotype.Service;
import com.cmx.test.service.SysUsersService;
import com.cmx.test.shiro.helper.PasswordHelper;
import com.cmx.test.dao.SysUsersDao;
import com.cmx.test.entity.SysUsers;
import com.cmx.test.base.BaseServiceImpl;

@Service("sysUsersService")
public class SysUsersServiceImpl extends BaseServiceImpl<SysUsers> implements SysUsersService {

	private PasswordHelper passwordHelper;
	
	public PasswordHelper getPasswordHelper() {
		return passwordHelper;
	}
	
	
	public void setPasswordHelper(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

	@Override
	public SysUsers addUser(SysUsers user) {
		passwordHelper.encryptPassword(user);
		Integer ret = ((SysUsersDao)dao).add(user);
		if(ret==1){
			return new SysUsers(user.getUsername(),null);
		}
		return new SysUsers();
	}

	@Override
	public SysUsers findUserByName(String username) {
		SysUsers sysUsers = new SysUsers();
		sysUsers.setUsername(username);
		return ((SysUsersDao)dao).query(sysUsers).get(0);
	}


}