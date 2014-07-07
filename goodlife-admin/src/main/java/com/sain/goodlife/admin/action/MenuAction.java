package com.sain.goodlife.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sain.goodlife.api.busine3system.shiro.ShiroPermissionsBusiness;

@Controller
@RequestMapping("/")
public class MenuAction {

	@Autowired
	private ShiroPermissionsBusiness permissionsBusiness;

	@RequestMapping("/index")
	public String test(){
		permissionsBusiness.test();
		return "/index";
	}

}
