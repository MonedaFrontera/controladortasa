package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Transaccionerror;
import com.monedafrontera.dto.TransaccionerrorId;

/**
 * Home object for domain model class Transaccionerror.
 * @see com.monedafrontera.dto.Transaccionerror
 * @author Hibernate Tools
 */
public class TransaccionerrorHome {

	private static final Log log = LogFactory.getLog(TransaccionerrorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Transaccionerror transientInstance) {
		log.debug("persisting Transaccionerror instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Transaccionerror instance) {
		log.debug("attaching dirty Transaccionerror instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Transaccionerror instance) {
		log.debug("attaching clean Transaccionerror instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Transaccionerror persistentInstance) {
		log.debug("deleting Transaccionerror instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Transaccionerror merge(Transaccionerror detachedInstance) {
		log.debug("merging Transaccionerror instance");
		try {
			Transaccionerror result = (Transaccionerror) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transaccionerror findById(com.monedafrontera.dto.TransaccionerrorId id) {
		log.debug("getting Transaccionerror instance with id: " + id);
		try {
			Transaccionerror instance = (Transaccionerror) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Transaccionerror", id);
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

	public List findByExample(Transaccionerror instance) {
		log.debug("finding Transaccionerror instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Transaccionerror")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
