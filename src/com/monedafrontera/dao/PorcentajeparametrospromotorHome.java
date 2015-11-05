package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Porcentajeparametrospromotor;
import com.monedafrontera.dto.PorcentajeparametrospromotorId;

/**
 * Home object for domain model class Porcentajeparametrospromotor.
 * @see com.monedafrontera.dto.Porcentajeparametrospromotor
 * @author Hibernate Tools
 */
public class PorcentajeparametrospromotorHome {

	private static final Log log = LogFactory.getLog(PorcentajeparametrospromotorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Porcentajeparametrospromotor transientInstance) {
		log.debug("persisting Porcentajeparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Porcentajeparametrospromotor instance) {
		log.debug("attaching dirty Porcentajeparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Porcentajeparametrospromotor instance) {
		log.debug("attaching clean Porcentajeparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Porcentajeparametrospromotor persistentInstance) {
		log.debug("deleting Porcentajeparametrospromotor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Porcentajeparametrospromotor merge(Porcentajeparametrospromotor detachedInstance) {
		log.debug("merging Porcentajeparametrospromotor instance");
		try {
			Porcentajeparametrospromotor result = (Porcentajeparametrospromotor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Porcentajeparametrospromotor findById(com.monedafrontera.dto.PorcentajeparametrospromotorId id) {
		log.debug("getting Porcentajeparametrospromotor instance with id: " + id);
		try {
			Porcentajeparametrospromotor instance = (Porcentajeparametrospromotor) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Porcentajeparametrospromotor", id);
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

	public List findByExample(Porcentajeparametrospromotor instance) {
		log.debug("finding Porcentajeparametrospromotor instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Porcentajeparametrospromotor").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
