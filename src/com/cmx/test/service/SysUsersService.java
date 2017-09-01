package com.cmx.test.service;

import com.cmx.test.entity.SysUsers;
import com.cmx.test.base.BaseService;

public interface SysUsersService extends BaseService<SysUsers> {
	
	
	//添加用户,将密码加密
	public SysUsers addUser(SysUsers user);
	//根据用户名查找用户
	public SysUsers findUserByName(String username);
	


}