package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Puntoestablecimiento;
import com.monedafrontera.dto.PuntoestablecimientoId;

/**
 * Home object for domain model class Puntoestablecimiento.
 * @see com.monedafrontera.dto.Puntoestablecimiento
 * @author Hibernate Tools
 */
public class PuntoestablecimientoHome {

	private static final Log log = LogFactory.getLog(PuntoestablecimientoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Puntoestablecimiento transientInstance) {
		log.debug("persisting Puntoestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Puntoestablecimiento instance) {
		log.debug("attaching dirty Puntoestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Puntoestablecimiento instance) {
		log.debug("attaching clean Puntoestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Puntoestablecimiento persistentInstance) {
		log.debug("deleting Puntoestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Puntoestablecimiento merge(Puntoestablecimiento detachedInstance) {
		log.debug("merging Puntoestablecimiento instance");
		try {
			Puntoestablecimiento result = (Puntoestablecimiento) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Puntoestablecimiento findById(com.monedafrontera.dto.PuntoestablecimientoId id) {
		log.debug("getting Puntoestablecimiento instance with id: " + id);
		try {
			Puntoestablecimiento instance = (Puntoestablecimiento) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Puntoestablecimiento", id);
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

	public List findByExample(Puntoestablecimiento instance) {
		log.debug("finding Puntoestablecimiento instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Puntoestablecimiento").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
