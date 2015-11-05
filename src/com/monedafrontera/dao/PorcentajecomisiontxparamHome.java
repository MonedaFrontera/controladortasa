package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Porcentajecomisiontxparam;

/**
 * Home object for domain model class Porcentajecomisiontxparam.
 * @see com.monedafrontera.dto.Porcentajecomisiontxparam
 * @author Hibernate Tools
 */
public class PorcentajecomisiontxparamHome {

	private static final Log log = LogFactory.getLog(PorcentajecomisiontxparamHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Porcentajecomisiontxparam transientInstance) {
		log.debug("persisting Porcentajecomisiontxparam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Porcentajecomisiontxparam instance) {
		log.debug("attaching dirty Porcentajecomisiontxparam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Porcentajecomisiontxparam instance) {
		log.debug("attaching clean Porcentajecomisiontxparam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Porcentajecomisiontxparam persistentInstance) {
		log.debug("deleting Porcentajecomisiontxparam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Porcentajecomisiontxparam merge(Porcentajecomisiontxparam detachedInstance) {
		log.debug("merging Porcentajecomisiontxparam instance");
		try {
			Porcentajecomisiontxparam result = (Porcentajecomisiontxparam) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Porcentajecomisiontxparam findById(int id) {
		log.debug("getting Porcentajecomisiontxparam instance with id: " + id);
		try {
			Porcentajecomisiontxparam instance = (Porcentajecomisiontxparam) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Porcentajecomisiontxparam", id);
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

	public List findByExample(Porcentajecomisiontxparam instance) {
		log.debug("finding Porcentajecomisiontxparam instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Porcentajecomisiontxparam").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
