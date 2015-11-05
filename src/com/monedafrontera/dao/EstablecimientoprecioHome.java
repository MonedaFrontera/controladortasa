package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Establecimientoprecio;
import com.monedafrontera.dto.EstablecimientoprecioId;

/**
 * Home object for domain model class Establecimientoprecio.
 * @see com.monedafrontera.dto.Establecimientoprecio
 * @author Hibernate Tools
 */
public class EstablecimientoprecioHome {

	private static final Log log = LogFactory.getLog(EstablecimientoprecioHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Establecimientoprecio transientInstance) {
		log.debug("persisting Establecimientoprecio instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Establecimientoprecio instance) {
		log.debug("attaching dirty Establecimientoprecio instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Establecimientoprecio instance) {
		log.debug("attaching clean Establecimientoprecio instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Establecimientoprecio persistentInstance) {
		log.debug("deleting Establecimientoprecio instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Establecimientoprecio merge(Establecimientoprecio detachedInstance) {
		log.debug("merging Establecimientoprecio instance");
		try {
			Establecimientoprecio result = (Establecimientoprecio) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Establecimientoprecio findById(com.monedafrontera.dto.EstablecimientoprecioId id) {
		log.debug("getting Establecimientoprecio instance with id: " + id);
		try {
			Establecimientoprecio instance = (Establecimientoprecio) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Establecimientoprecio", id);
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

	public List findByExample(Establecimientoprecio instance) {
		log.debug("finding Establecimientoprecio instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Establecimientoprecio").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
