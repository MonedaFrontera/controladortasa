package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Gravamenestablecimiento;
import com.monedafrontera.dto.GravamenestablecimientoId;

/**
 * Home object for domain model class Gravamenestablecimiento.
 * @see com.monedafrontera.dto.Gravamenestablecimiento
 * @author Hibernate Tools
 */
public class GravamenestablecimientoHome {

	private static final Log log = LogFactory.getLog(GravamenestablecimientoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Gravamenestablecimiento transientInstance) {
		log.debug("persisting Gravamenestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Gravamenestablecimiento instance) {
		log.debug("attaching dirty Gravamenestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Gravamenestablecimiento instance) {
		log.debug("attaching clean Gravamenestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Gravamenestablecimiento persistentInstance) {
		log.debug("deleting Gravamenestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Gravamenestablecimiento merge(Gravamenestablecimiento detachedInstance) {
		log.debug("merging Gravamenestablecimiento instance");
		try {
			Gravamenestablecimiento result = (Gravamenestablecimiento) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Gravamenestablecimiento findById(com.monedafrontera.dto.GravamenestablecimientoId id) {
		log.debug("getting Gravamenestablecimiento instance with id: " + id);
		try {
			Gravamenestablecimiento instance = (Gravamenestablecimiento) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Gravamenestablecimiento", id);
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

	public List findByExample(Gravamenestablecimiento instance) {
		log.debug("finding Gravamenestablecimiento instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Gravamenestablecimiento").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
