package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistaactobservacion;
import com.monedafrontera.dto.VistaactobservacionId;

/**
 * Home object for domain model class Vistaactobservacion.
 * @see com.monedafrontera.dto.Vistaactobservacion
 * @author Hibernate Tools
 */
public class VistaactobservacionHome {

	private static final Log log = LogFactory.getLog(VistaactobservacionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistaactobservacion transientInstance) {
		log.debug("persisting Vistaactobservacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistaactobservacion instance) {
		log.debug("attaching dirty Vistaactobservacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistaactobservacion instance) {
		log.debug("attaching clean Vistaactobservacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistaactobservacion persistentInstance) {
		log.debug("deleting Vistaactobservacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistaactobservacion merge(Vistaactobservacion detachedInstance) {
		log.debug("merging Vistaactobservacion instance");
		try {
			Vistaactobservacion result = (Vistaactobservacion) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistaactobservacion findById(com.monedafrontera.dto.VistaactobservacionId id) {
		log.debug("getting Vistaactobservacion instance with id: " + id);
		try {
			Vistaactobservacion instance = (Vistaactobservacion) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistaactobservacion", id);
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

	public List findByExample(Vistaactobservacion instance) {
		log.debug("finding Vistaactobservacion instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Vistaactobservacion").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
