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

import com.sain.goodlife.api.dao.shiro.ShiroRolesDao;
import com.sain.goodlife.api.entity.po.shiro.ShiroRolesPoEntity;

@Repository("shiroRolesDao")
public class ShiroRolesDaoImpl implements ShiroRolesDao {

	private static final Log log = LogFactory.getLog(ShiroRolesDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(ShiroRolesPoEntity transientInstance) {
		log.debug("persisting ShiroRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShiroRolesPoEntity instance) {
		log.debug("attaching dirty ShiroRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShiroRolesPoEntity instance) {
		log.debug("attaching clean ShiroRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShiroRolesPoEntity persistentInstance) {
		log.debug("deleting ShiroRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShiroRolesPoEntity merge(ShiroRolesPoEntity detachedInstance) {
		log.debug("merging ShiroRolesT1 instance");
		try {
			ShiroRolesPoEntity result = (ShiroRolesPoEntity) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShiroRolesPoEntity findById(long id) {
		log.debug("getting ShiroRolesT1 instance with id: " + id);
		try {
			ShiroRolesPoEntity instance = (ShiroRolesPoEntity) sessionFactory
					.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.ShiroRolesT1",
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

	public List<?> findByExample(ShiroRolesPoEntity instance) {
		log.debug("finding ShiroRolesT1 instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.ShiroRolesT1")
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
	public int insert(ShiroRolesPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ShiroRolesPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShiroRolesPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShiroRolesPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
