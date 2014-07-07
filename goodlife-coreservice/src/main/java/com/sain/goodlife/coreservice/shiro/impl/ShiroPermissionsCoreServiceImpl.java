package com.sain.goodlife.coreservice.shiro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.basicservice.shiro.ShiroPermissionsBasicService;
import com.sain.goodlife.api.coreservice.shiro.ShiroPermissionsCoreService;

@Service("shiroPermissionsCoreService")
public class ShiroPermissionsCoreServiceImpl implements ShiroPermissionsCoreService {

	@Autowired
	private ShiroPermissionsBasicService permissionsBasicService;

	public void test(){
		permissionsBasicService.test();
	}

}
