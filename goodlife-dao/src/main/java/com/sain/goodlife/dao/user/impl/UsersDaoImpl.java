package com.sain.goodlife.dao.user.impl;

// Generated 2014-5-27 15:50:27 by Hibernate Tools 4.0.0

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sain.goodlife.api.dao.user.UsersDao;
import com.sain.goodlife.api.entity.po.user.UsersPoEntity;

@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

	private static final Log log = LogFactory.getLog(UsersDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(UsersPoEntity transientInstance) {
		log.debug("persisting UsersT1 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UsersPoEntity instance) {
		log.debug("attaching dirty UsersT1 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(UsersPoEntity instance) {
		log.debug("attaching clean UsersT1 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UsersPoEntity persistentInstance) {
		log.debug("deleting UsersT1 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UsersPoEntity merge(UsersPoEntity detachedInstance) {
		log.debug("merging UsersT1 instance");
		try {
			UsersPoEntity result = (UsersPoEntity) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UsersPoEntity findById(long id) {
		log.debug("getting UsersT1 instance with id: " + id);
		try {
			UsersPoEntity instance = (UsersPoEntity) sessionFactory.getCurrentSession()
					.get("com.sain.goodlife.api.entity.po.shiro.UsersT1", id);
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

	public List<?> findByExample(UsersPoEntity instance) {
		log.debug("finding UsersT1 instance by example");
		try {
			List<?> results = sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.sain.goodlife.api.entity.po.shiro.UsersT1")
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
	public int insert(UsersPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UsersPoEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsersPoEntity selectById(Integer pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersPoEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
