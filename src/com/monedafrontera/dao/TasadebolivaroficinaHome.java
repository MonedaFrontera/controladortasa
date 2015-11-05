package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasadebolivaroficina;
import com.monedafrontera.dto.TasadebolivaroficinaId;

/**
 * Home object for domain model class Tasadebolivaroficina.
 * @see com.monedafrontera.dto.Tasadebolivaroficina
 * @author Hibernate Tools
 */
public class TasadebolivaroficinaHome {

	private static final Log log = LogFactory.getLog(TasadebolivaroficinaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasadebolivaroficina transientInstance) {
		log.debug("persisting Tasadebolivaroficina instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasadebolivaroficina instance) {
		log.debug("attaching dirty Tasadebolivaroficina instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasadebolivaroficina instance) {
		log.debug("attaching clean Tasadebolivaroficina instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasadebolivaroficina persistentInstance) {
		log.debug("deleting Tasadebolivaroficina instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasadebolivaroficina merge(Tasadebolivaroficina detachedInstance) {
		log.debug("merging Tasadebolivaroficina instance");
		try {
			Tasadebolivaroficina result = (Tasadebolivaroficina) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasadebolivaroficina findById(com.monedafrontera.dto.TasadebolivaroficinaId id) {
		log.debug("getting Tasadebolivaroficina instance with id: " + id);
		try {
			Tasadebolivaroficina instance = (Tasadebolivaroficina) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasadebolivaroficina", id);
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

	public List findByExample(Tasadebolivaroficina instance) {
		log.debug("finding Tasadebolivaroficina instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasadebolivaroficina").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
