package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Saldodepositos;
import com.monedafrontera.dto.SaldodepositosId;

/**
 * Home object for domain model class Saldodepositos.
 * @see com.monedafrontera.dto.Saldodepositos
 * @author Hibernate Tools
 */
public class SaldodepositosHome {

	private static final Log log = LogFactory.getLog(SaldodepositosHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Saldodepositos transientInstance) {
		log.debug("persisting Saldodepositos instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Saldodepositos instance) {
		log.debug("attaching dirty Saldodepositos instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Saldodepositos instance) {
		log.debug("attaching clean Saldodepositos instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Saldodepositos persistentInstance) {
		log.debug("deleting Saldodepositos instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Saldodepositos merge(Saldodepositos detachedInstance) {
		log.debug("merging Saldodepositos instance");
		try {
			Saldodepositos result = (Saldodepositos) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Saldodepositos findById(com.monedafrontera.dto.SaldodepositosId id) {
		log.debug("getting Saldodepositos instance with id: " + id);
		try {
			Saldodepositos instance = (Saldodepositos) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Saldodepositos", id);
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

	public List findByExample(Saldodepositos instance) {
		log.debug("finding Saldodepositos instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Saldodepositos")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
