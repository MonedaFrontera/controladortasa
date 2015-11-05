package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasadolarparametrospromotor;
import com.monedafrontera.dto.TasadolarparametrospromotorId;

/**
 * Home object for domain model class Tasadolarparametrospromotor.
 * @see com.monedafrontera.dto.Tasadolarparametrospromotor
 * @author Hibernate Tools
 */
public class TasadolarparametrospromotorHome {

	private static final Log log = LogFactory.getLog(TasadolarparametrospromotorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasadolarparametrospromotor transientInstance) {
		log.debug("persisting Tasadolarparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasadolarparametrospromotor instance) {
		log.debug("attaching dirty Tasadolarparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasadolarparametrospromotor instance) {
		log.debug("attaching clean Tasadolarparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasadolarparametrospromotor persistentInstance) {
		log.debug("deleting Tasadolarparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasadolarparametrospromotor merge(Tasadolarparametrospromotor detachedInstance) {
		log.debug("merging Tasadolarparametrospromotor instance");
		try {
			Tasadolarparametrospromotor result = (Tasadolarparametrospromotor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasadolarparametrospromotor findById(com.monedafrontera.dto.TasadolarparametrospromotorId id) {
		log.debug("getting Tasadolarparametrospromotor instance with id: " + id);
		try {
			Tasadolarparametrospromotor instance = (Tasadolarparametrospromotor) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasadolarparametrospromotor", id);
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

	public List findByExample(Tasadolarparametrospromotor instance) {
		log.debug("finding Tasadolarparametrospromotor instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasadolarparametrospromotor").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
