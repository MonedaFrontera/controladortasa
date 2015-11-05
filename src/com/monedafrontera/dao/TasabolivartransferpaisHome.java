package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasabolivartransferpais;
import com.monedafrontera.dto.TasabolivartransferpaisId;

/**
 * Home object for domain model class Tasabolivartransferpais.
 * @see com.monedafrontera.dto.Tasabolivartransferpais
 * @author Hibernate Tools
 */
public class TasabolivartransferpaisHome {

	private static final Log log = LogFactory.getLog(TasabolivartransferpaisHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasabolivartransferpais transientInstance) {
		log.debug("persisting Tasabolivartransferpais instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasabolivartransferpais instance) {
		log.debug("attaching dirty Tasabolivartransferpais instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasabolivartransferpais instance) {
		log.debug("attaching clean Tasabolivartransferpais instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasabolivartransferpais persistentInstance) {
		log.debug("deleting Tasabolivartransferpais instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasabolivartransferpais merge(Tasabolivartransferpais detachedInstance) {
		log.debug("merging Tasabolivartransferpais instance");
		try {
			Tasabolivartransferpais result = (Tasabolivartransferpais) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasabolivartransferpais findById(com.monedafrontera.dto.TasabolivartransferpaisId id) {
		log.debug("getting Tasabolivartransferpais instance with id: " + id);
		try {
			Tasabolivartransferpais instance = (Tasabolivartransferpais) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasabolivartransferpais", id);
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

	public List findByExample(Tasabolivartransferpais instance) {
		log.debug("finding Tasabolivartransferpais instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasabolivartransferpais").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
