package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Solicitudtarjeta;
import com.monedafrontera.dto.SolicitudtarjetaId;

/**
 * Home object for domain model class Solicitudtarjeta.
 * @see com.monedafrontera.dto.Solicitudtarjeta
 * @author Hibernate Tools
 */
public class SolicitudtarjetaHome {

	private static final Log log = LogFactory.getLog(SolicitudtarjetaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Solicitudtarjeta transientInstance) {
		log.debug("persisting Solicitudtarjeta instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Solicitudtarjeta instance) {
		log.debug("attaching dirty Solicitudtarjeta instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Solicitudtarjeta instance) {
		log.debug("attaching clean Solicitudtarjeta instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Solicitudtarjeta persistentInstance) {
		log.debug("deleting Solicitudtarjeta instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Solicitudtarjeta merge(Solicitudtarjeta detachedInstance) {
		log.debug("merging Solicitudtarjeta instance");
		try {
			Solicitudtarjeta result = (Solicitudtarjeta) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Solicitudtarjeta findById(com.monedafrontera.dto.SolicitudtarjetaId id) {
		log.debug("getting Solicitudtarjeta instance with id: " + id);
		try {
			Solicitudtarjeta instance = (Solicitudtarjeta) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Solicitudtarjeta", id);
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

	public List findByExample(Solicitudtarjeta instance) {
		log.debug("finding Solicitudtarjeta instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Solicitudtarjeta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
