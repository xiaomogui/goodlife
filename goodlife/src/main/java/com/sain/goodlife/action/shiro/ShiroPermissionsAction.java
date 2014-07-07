package com.sain.goodlife.action.shiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sain.goodlife.api.busine3system.shiro.ShiroPermissionsBusiness;

@Controller
@RequestMapping("/shiro/permission")
public class ShiroPermissionsAction {

	@Autowired
	private ShiroPermissionsBusiness permissionsBusiness;

	@RequestMapping("/test")
	public String test(){
		permissionsBusiness.test();
		return "/skins/index";
	}

}
