package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Paridadmoneda;

/**
 * Home object for domain model class Paridadmoneda.
 * @see com.monedafrontera.dto.Paridadmoneda
 * @author Hibernate Tools
 */
public class ParidadmonedaHome {

	private static final Log log = LogFactory.getLog(ParidadmonedaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Paridadmoneda transientInstance) {
		log.debug("persisting Paridadmoneda instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Paridadmoneda instance) {
		log.debug("attaching dirty Paridadmoneda instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Paridadmoneda instance) {
		log.debug("attaching clean Paridadmoneda instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Paridadmoneda persistentInstance) {
		log.debug("deleting Paridadmoneda instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Paridadmoneda merge(Paridadmoneda detachedInstance) {
		log.debug("merging Paridadmoneda instance");
		try {
			Paridadmoneda result = (Paridadmoneda) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Paridadmoneda findById(java.util.Date id) {
		log.debug("getting Paridadmoneda instance with id: " + id);
		try {
			Paridadmoneda instance = (Paridadmoneda) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Paridadmoneda", id);
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

	public List findByExample(Paridadmoneda instance) {
		log.debug("finding Paridadmoneda instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Paridadmoneda")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
