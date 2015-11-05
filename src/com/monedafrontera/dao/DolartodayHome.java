package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Dolartoday;

/**
 * Home object for domain model class Dolartoday.
 * @see com.monedafrontera.dto.Dolartoday
 * @author Hibernate Tools
 */
public class DolartodayHome {

	private static final Log log = LogFactory.getLog(DolartodayHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Dolartoday transientInstance) {
		log.debug("persisting Dolartoday instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Dolartoday instance) {
		log.debug("attaching dirty Dolartoday instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dolartoday instance) {
		log.debug("attaching clean Dolartoday instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Dolartoday persistentInstance) {
		log.debug("deleting Dolartoday instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dolartoday merge(Dolartoday detachedInstance) {
		log.debug("merging Dolartoday instance");
		try {
			Dolartoday result = (Dolartoday) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Dolartoday findById(long id) {
		log.debug("getting Dolartoday instance with id: " + id);
		try {
			Dolartoday instance = (Dolartoday) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Dolartoday", id);
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

	public List findByExample(Dolartoday instance) {
		log.debug("finding Dolartoday instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Dolartoday")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
