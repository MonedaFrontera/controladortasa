package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistaactivaciones;
import com.monedafrontera.dto.VistaactivacionesId;

/**
 * Home object for domain model class Vistaactivaciones.
 * @see com.monedafrontera.dto.Vistaactivaciones
 * @author Hibernate Tools
 */
public class VistaactivacionesHome {

	private static final Log log = LogFactory.getLog(VistaactivacionesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistaactivaciones transientInstance) {
		log.debug("persisting Vistaactivaciones instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistaactivaciones instance) {
		log.debug("attaching dirty Vistaactivaciones instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistaactivaciones instance) {
		log.debug("attaching clean Vistaactivaciones instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistaactivaciones persistentInstance) {
		log.debug("deleting Vistaactivaciones instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistaactivaciones merge(Vistaactivaciones detachedInstance) {
		log.debug("merging Vistaactivaciones instance");
		try {
			Vistaactivaciones result = (Vistaactivaciones) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistaactivaciones findById(com.monedafrontera.dto.VistaactivacionesId id) {
		log.debug("getting Vistaactivaciones instance with id: " + id);
		try {
			Vistaactivaciones instance = (Vistaactivaciones) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistaactivaciones", id);
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

	public List findByExample(Vistaactivaciones instance) {
		log.debug("finding Vistaactivaciones instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistaactivaciones")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
