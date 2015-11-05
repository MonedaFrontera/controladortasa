package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Cuentapromotor;
import com.monedafrontera.dto.CuentapromotorId;

/**
 * Home object for domain model class Cuentapromotor.
 * @see com.monedafrontera.dto.Cuentapromotor
 * @author Hibernate Tools
 */
public class CuentapromotorHome {

	private static final Log log = LogFactory.getLog(CuentapromotorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Cuentapromotor transientInstance) {
		log.debug("persisting Cuentapromotor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cuentapromotor instance) {
		log.debug("attaching dirty Cuentapromotor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cuentapromotor instance) {
		log.debug("attaching clean Cuentapromotor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cuentapromotor persistentInstance) {
		log.debug("deleting Cuentapromotor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cuentapromotor merge(Cuentapromotor detachedInstance) {
		log.debug("merging Cuentapromotor instance");
		try {
			Cuentapromotor result = (Cuentapromotor) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cuentapromotor findById(com.monedafrontera.dto.CuentapromotorId id) {
		log.debug("getting Cuentapromotor instance with id: " + id);
		try {
			Cuentapromotor instance = (Cuentapromotor) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Cuentapromotor", id);
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

	public List findByExample(Cuentapromotor instance) {
		log.debug("finding Cuentapromotor instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Cuentapromotor")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
