package com.sain.goodlife.dao.user.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sain.goodlife.api.dao.user.AdminDao;
import com.sain.goodlife.api.entity.po.user.AdminPoEntity;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	private static final Log log = LogFactory.getLog(AdminDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(AdminPoEntity transientInstance) {
		log.debug("persisting AdminPoEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AdminPoEntity instance) {
		log.debug("attaching dirty AdminPoEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(AdminPoEntity instance) {
		log.debug("attaching clean AdminPoEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AdminPoEntity persistentInstance) {
		log.debug("deleting AdminPoEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdminPoEntity merge(AdminPoEntity detachedInstance) {
		log.debug("merging AdminPoEntity instance");
		try {
			AdminPoEntity result = (AdminPoEntity) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AdminPoEntity findById(long id) {
		log.debug("getting AdminPoEntity instance with id: " + id);
		try {
			AdminPoEntity instance = (AdminPoEntity) sessionFactory.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.AdminPoEntity", id);
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

	public List<?> findByExample(AdminPoEntity instance) {
		log.debug("finding AdminPoEntity instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.AdminPoEntity")
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
	public int insert(AdminPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AdminPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
