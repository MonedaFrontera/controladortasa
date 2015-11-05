package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tarjetaviaje;
import com.monedafrontera.dto.TarjetaviajeId;

/**
 * Home object for domain model class Tarjetaviaje.
 * @see com.monedafrontera.dto.Tarjetaviaje
 * @author Hibernate Tools
 */
public class TarjetaviajeHome {

	private static final Log log = LogFactory.getLog(TarjetaviajeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tarjetaviaje transientInstance) {
		log.debug("persisting Tarjetaviaje instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tarjetaviaje instance) {
		log.debug("attaching dirty Tarjetaviaje instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tarjetaviaje instance) {
		log.debug("attaching clean Tarjetaviaje instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tarjetaviaje persistentInstance) {
		log.debug("deleting Tarjetaviaje instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tarjetaviaje merge(Tarjetaviaje detachedInstance) {
		log.debug("merging Tarjetaviaje instance");
		try {
			Tarjetaviaje result = (Tarjetaviaje) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tarjetaviaje findById(com.monedafrontera.dto.TarjetaviajeId id) {
		log.debug("getting Tarjetaviaje instance with id: " + id);
		try {
			Tarjetaviaje instance = (Tarjetaviaje) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tarjetaviaje", id);
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

	public List findByExample(Tarjetaviaje instance) {
		log.debug("finding Tarjetaviaje instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Tarjetaviaje")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
