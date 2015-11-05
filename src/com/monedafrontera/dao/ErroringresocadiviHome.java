package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Erroringresocadivi;
import com.monedafrontera.dto.ErroringresocadiviId;

/**
 * Home object for domain model class Erroringresocadivi.
 * @see com.monedafrontera.dto.Erroringresocadivi
 * @author Hibernate Tools
 */
public class ErroringresocadiviHome {

	private static final Log log = LogFactory.getLog(ErroringresocadiviHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Erroringresocadivi transientInstance) {
		log.debug("persisting Erroringresocadivi instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Erroringresocadivi instance) {
		log.debug("attaching dirty Erroringresocadivi instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Erroringresocadivi instance) {
		log.debug("attaching clean Erroringresocadivi instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Erroringresocadivi persistentInstance) {
		log.debug("deleting Erroringresocadivi instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Erroringresocadivi merge(Erroringresocadivi detachedInstance) {
		log.debug("merging Erroringresocadivi instance");
		try {
			Erroringresocadivi result = (Erroringresocadivi) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Erroringresocadivi findById(com.monedafrontera.dto.ErroringresocadiviId id) {
		log.debug("getting Erroringresocadivi instance with id: " + id);
		try {
			Erroringresocadivi instance = (Erroringresocadivi) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Erroringresocadivi", id);
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

	public List findByExample(Erroringresocadivi instance) {
		log.debug("finding Erroringresocadivi instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Erroringresocadivi").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
