package com.sain.goodlife.dao.shiro.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sain.goodlife.api.dao.shiro.ShiroPermissionsDao;
import com.sain.goodlife.api.entity.po.shiro.ShiroPermissionsPoEntity;

@Repository("shiroPermissionsDao")
public class ShiroPermissionsDaoImpl implements ShiroPermissionsDao {

	private static final Log log = LogFactory.getLog(ShiroPermissionsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(ShiroPermissionsPoEntity transientInstance) {
		log.debug("persisting ShiroPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShiroPermissionsPoEntity instance) {
		log.debug("attaching dirty ShiroPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShiroPermissionsPoEntity instance) {
		log.debug("attaching clean ShiroPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShiroPermissionsPoEntity persistentInstance) {
		log.debug("deleting ShiroPermissionsPoEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShiroPermissionsPoEntity merge(ShiroPermissionsPoEntity detachedInstance) {
		log.debug("merging ShiroPermissionsPoEntity instance");
		try {
			ShiroPermissionsPoEntity result = (ShiroPermissionsPoEntity) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShiroPermissionsPoEntity findById(long id) {
		log.debug("getting ShiroPermissionsPoEntity instance with id: " + id);
		try {
			ShiroPermissionsPoEntity instance = (ShiroPermissionsPoEntity) sessionFactory
					.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.ShiroPermissionsPoEntity",
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

	public List<?> findByExample(ShiroPermissionsPoEntity instance) {
		log.debug("finding ShiroPermissionsPoEntity instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.ShiroPermissionsPoEntity")
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
	public int insert(ShiroPermissionsPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ShiroPermissionsPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShiroPermissionsPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShiroPermissionsPoEntity> findAll() {
		Session session = sessionFactory.openSession();
		List<ShiroPermissionsPoEntity> list = session.createQuery("FROM ShiroPermissionsPoEntity").list();
		return list;
	}
}
