package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Saldodiariopromotor;
import com.monedafrontera.dto.SaldodiariopromotorId;

/**
 * Home object for domain model class Saldodiariopromotor.
 * @see com.monedafrontera.dto.Saldodiariopromotor
 * @author Hibernate Tools
 */
public class SaldodiariopromotorHome {

	private static final Log log = LogFactory.getLog(SaldodiariopromotorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Saldodiariopromotor transientInstance) {
		log.debug("persisting Saldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Saldodiariopromotor instance) {
		log.debug("attaching dirty Saldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Saldodiariopromotor instance) {
		log.debug("attaching clean Saldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Saldodiariopromotor persistentInstance) {
		log.debug("deleting Saldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Saldodiariopromotor merge(Saldodiariopromotor detachedInstance) {
		log.debug("merging Saldodiariopromotor instance");
		try {
			Saldodiariopromotor result = (Saldodiariopromotor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Saldodiariopromotor findById(com.monedafrontera.dto.SaldodiariopromotorId id) {
		log.debug("getting Saldodiariopromotor instance with id: " + id);
		try {
			Saldodiariopromotor instance = (Saldodiariopromotor) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Saldodiariopromotor", id);
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

	public List findByExample(Saldodiariopromotor instance) {
		log.debug("finding Saldodiariopromotor instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Saldodiariopromotor").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
