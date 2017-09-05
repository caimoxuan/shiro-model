package com.cmx.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmx.test.entity.SysUsers;
import com.cmx.test.service.SysUsersService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private SysUsersService sysUsersService;
	
	@RequestMapping("")
	public String root(){
		return "user/user";
	}
	
	@ResponseBody
	@RequestMapping("/user")
	public Map<String, Object> getUser(SysUsers user){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			List<SysUsers> query = sysUsersService.query(user);
			resultMap.put("row", query);
		}catch(Exception e){
			
		}
		
		return resultMap;
	}

}
