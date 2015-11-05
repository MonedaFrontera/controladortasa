package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Franquiciaestablecimiento;
import com.monedafrontera.dto.FranquiciaestablecimientoId;

/**
 * Home object for domain model class Franquiciaestablecimiento.
 * @see com.monedafrontera.dto.Franquiciaestablecimiento
 * @author Hibernate Tools
 */
public class FranquiciaestablecimientoHome {

	private static final Log log = LogFactory.getLog(FranquiciaestablecimientoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Franquiciaestablecimiento transientInstance) {
		log.debug("persisting Franquiciaestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Franquiciaestablecimiento instance) {
		log.debug("attaching dirty Franquiciaestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Franquiciaestablecimiento instance) {
		log.debug("attaching clean Franquiciaestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Franquiciaestablecimiento persistentInstance) {
		log.debug("deleting Franquiciaestablecimiento instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Franquiciaestablecimiento merge(Franquiciaestablecimiento detachedInstance) {
		log.debug("merging Franquiciaestablecimiento instance");
		try {
			Franquiciaestablecimiento result = (Franquiciaestablecimiento) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Franquiciaestablecimiento findById(com.monedafrontera.dto.FranquiciaestablecimientoId id) {
		log.debug("getting Franquiciaestablecimiento instance with id: " + id);
		try {
			Franquiciaestablecimiento instance = (Franquiciaestablecimiento) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Franquiciaestablecimiento", id);
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

	public List findByExample(Franquiciaestablecimiento instance) {
		log.debug("finding Franquiciaestablecimiento instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Franquiciaestablecimiento").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
