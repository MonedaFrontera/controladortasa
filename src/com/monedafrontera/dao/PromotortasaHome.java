package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Promotortasa;
import com.monedafrontera.dto.PromotortasaId;

/**
 * Home object for domain model class Promotortasa.
 * @see com.monedafrontera.dto.Promotortasa
 * @author Hibernate Tools
 */
public class PromotortasaHome {

	private static final Log log = LogFactory.getLog(PromotortasaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Promotortasa transientInstance) {
		log.debug("persisting Promotortasa instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Promotortasa instance) {
		log.debug("attaching dirty Promotortasa instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Promotortasa instance) {
		log.debug("attaching clean Promotortasa instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Promotortasa persistentInstance) {
		log.debug("deleting Promotortasa instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Promotortasa merge(Promotortasa detachedInstance) {
		log.debug("merging Promotortasa instance");
		try {
			Promotortasa result = (Promotortasa) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Promotortasa findById(com.monedafrontera.dto.PromotortasaId id) {
		log.debug("getting Promotortasa instance with id: " + id);
		try {
			Promotortasa instance = (Promotortasa) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Promotortasa", id);
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

	public List findByExample(Promotortasa instance) {
		log.debug("finding Promotortasa instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Promotortasa")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
