package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Porcentcomisiontxparampromo;

/**
 * Home object for domain model class Porcentcomisiontxparampromo.
 * @see com.monedafrontera.dto.Porcentcomisiontxparampromo
 * @author Hibernate Tools
 */
public class PorcentcomisiontxparampromoHome {

	private static final Log log = LogFactory.getLog(PorcentcomisiontxparampromoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Porcentcomisiontxparampromo transientInstance) {
		log.debug("persisting Porcentcomisiontxparampromo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Porcentcomisiontxparampromo instance) {
		log.debug("attaching dirty Porcentcomisiontxparampromo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Porcentcomisiontxparampromo instance) {
		log.debug("attaching clean Porcentcomisiontxparampromo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Porcentcomisiontxparampromo persistentInstance) {
		log.debug("deleting Porcentcomisiontxparampromo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Porcentcomisiontxparampromo merge(Porcentcomisiontxparampromo detachedInstance) {
		log.debug("merging Porcentcomisiontxparampromo instance");
		try {
			Porcentcomisiontxparampromo result = (Porcentcomisiontxparampromo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Porcentcomisiontxparampromo findById(int id) {
		log.debug("getting Porcentcomisiontxparampromo instance with id: " + id);
		try {
			Porcentcomisiontxparampromo instance = (Porcentcomisiontxparampromo) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Porcentcomisiontxparampromo", id);
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

	public List findByExample(Porcentcomisiontxparampromo instance) {
		log.debug("finding Porcentcomisiontxparampromo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Porcentcomisiontxparampromo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
