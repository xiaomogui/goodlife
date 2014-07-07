package com.sain.goodlife.busine3system.shiro.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.busine3system.shiro.ShiroPermissionsBusiness;
import com.sain.goodlife.api.coreservice.shiro.ShiroPermissionsCoreService;

@Service("shiroPermissionsBusiness")
public class ShiroPermissionsBusinessImpl implements ShiroPermissionsBusiness {

	@Autowired
	private ShiroPermissionsCoreService permissionsCoreService;

	@Override
	public void test() {
		permissionsCoreService.test();
	}

}
