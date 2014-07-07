package com.sain.goodlife.dao.shiro.impl;

// Generated 2014-5-27 15:50:27 by Hibernate Tools 4.0.0

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sain.goodlife.api.dao.shiro.ShiroRolesPermissionsDao;
import com.sain.goodlife.api.entity.po.shiro.ShiroRolesPermissionsIdPoEntity;
import com.sain.goodlife.api.entity.po.shiro.ShiroRolesPermissionsPoEntity;

@Repository("shiroRolesPermissionsDao")
public class ShiroRolesPermissionsDaoImpl implements ShiroRolesPermissionsDao {

	private static final Log log = LogFactory
			.getLog(ShiroRolesPermissionsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(ShiroRolesPermissionsPoEntity transientInstance) {
		log.debug("persisting ShiroRolesPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShiroRolesPermissionsPoEntity instance) {
		log.debug("attaching dirty ShiroRolesPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShiroRolesPermissionsPoEntity instance) {
		log.debug("attaching clean ShiroRolesPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShiroRolesPermissionsPoEntity persistentInstance) {
		log.debug("deleting ShiroRolesPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShiroRolesPermissionsPoEntity merge(
			ShiroRolesPermissionsPoEntity detachedInstance) {
		log.debug("merging ShiroRolesPermissionsPoEntity instance");
		try {
			ShiroRolesPermissionsPoEntity result = (ShiroRolesPermissionsPoEntity) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShiroRolesPermissionsPoEntity findById(ShiroRolesPermissionsIdPoEntity id) {
		log.debug("getting ShiroRolesPermissionsPoEntity instance with id: " + id);
		try {
			ShiroRolesPermissionsPoEntity instance = (ShiroRolesPermissionsPoEntity) sessionFactory
					.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.ShiroRolesPermissionsPoEntity",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(ShiroRolesPermissionsPoEntity instance) {
		log.debug("finding ShiroRolesPermissionsPoEntity instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.ShiroRolesPermissionsPoEntity")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public int insert(ShiroRolesPermissionsPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ShiroRolesPermissionsPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShiroRolesPermissionsPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShiroRolesPermissionsPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
