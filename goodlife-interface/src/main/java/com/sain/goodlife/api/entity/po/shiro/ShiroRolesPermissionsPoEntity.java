package com.sain.goodlife.api.entity.po.shiro;

import com.sain.goodlife.api.entity.po.PoEntity;

// Generated 2014-5-27 15:50:26 by Hibernate Tools 4.0.0

/**
 * ShiroRolesPermissionsT1 generated by hbm2java
 */
public class ShiroRolesPermissionsPoEntity implements PoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ShiroRolesPermissionsIdPoEntity id;

	public ShiroRolesPermissionsPoEntity() {
	}

	public ShiroRolesPermissionsPoEntity(ShiroRolesPermissionsIdPoEntity id) {
		this.id = id;
	}

	public ShiroRolesPermissionsIdPoEntity getId() {
		return this.id;
	}

	public void setId(ShiroRolesPermissionsIdPoEntity id) {
		this.id = id;
	}

}
