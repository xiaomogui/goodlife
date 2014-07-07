package com.sain.goodlife.basicservice.shiro.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sain.goodlife.api.basicservice.shiro.ShiroPermissionsBasicService;
import com.sain.goodlife.api.dao.shiro.ShiroPermissionsDao;
import com.sain.goodlife.api.entity.po.shiro.ShiroPermissionsPoEntity;

@Service("shiroPermissionsBasicService")
public class ShiroPermissionsBasicServiceImpl implements ShiroPermissionsBasicService {

	@Autowired
	private ShiroPermissionsDao permissionsDao;

	public void test(){
		List<ShiroPermissionsPoEntity> list = permissionsDao.findAll();
		for(ShiroPermissionsPoEntity permissionsPoEntity : list){
			System.out.println(permissionsPoEntity.getPermission());
		}
	}

}
