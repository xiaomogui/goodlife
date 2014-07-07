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

import com.sain.goodlife.api.dao.shiro.ShiroUsersRolesDao;
import com.sain.goodlife.api.entity.po.shiro.ShiroUsersRolesIdPoEntity;
import com.sain.goodlife.api.entity.po.shiro.ShiroUsersRolesPoEntity;

@Repository("shiroUsersRolesDao")
public class ShiroUsersRolesDaoImpl implements ShiroUsersRolesDao {

	private static final Log log = LogFactory
			.getLog(ShiroUsersRolesDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(ShiroUsersRolesPoEntity transientInstance) {
		log.debug("persisting ShiroUsersRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShiroUsersRolesPoEntity instance) {
		log.debug("attaching dirty ShiroUsersRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ShiroUsersRolesPoEntity instance) {
		log.debug("attaching clean ShiroUsersRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShiroUsersRolesPoEntity persistentInstance) {
		log.debug("deleting ShiroUsersRolesT1 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShiroUsersRolesPoEntity merge(ShiroUsersRolesPoEntity detachedInstance) {
		log.debug("merging ShiroUsersRolesT1 instance");
		try {
			ShiroUsersRolesPoEntity result = (ShiroUsersRolesPoEntity) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShiroUsersRolesPoEntity findById(ShiroUsersRolesIdPoEntity id) {
		log.debug("getting ShiroUsersRolesT1 instance with id: " + id);
		try {
			ShiroUsersRolesPoEntity instance = (ShiroUsersRolesPoEntity) sessionFactory
					.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.ShiroUsersRolesT1",
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

	public List<?> findByExample(ShiroUsersRolesPoEntity instance) {
		log.debug("finding ShiroUsersRolesT1 instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.ShiroUsersRolesT1")
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
	public int insert(ShiroUsersRolesPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ShiroUsersRolesPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ShiroUsersRolesPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShiroUsersRolesPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
