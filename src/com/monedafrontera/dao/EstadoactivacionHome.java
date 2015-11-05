package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Estadoactivacion;
import com.monedafrontera.dto.EstadoactivacionId;

/**
 * Home object for domain model class Estadoactivacion.
 * @see com.monedafrontera.dto.Estadoactivacion
 * @author Hibernate Tools
 */
public class EstadoactivacionHome {

	private static final Log log = LogFactory.getLog(EstadoactivacionHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Estadoactivacion transientInstance) {
		log.debug("persisting Estadoactivacion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Estadoactivacion instance) {
		log.debug("attaching dirty Estadoactivacion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Estadoactivacion instance) {
		log.debug("attaching clean Estadoactivacion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Estadoactivacion persistentInstance) {
		log.debug("deleting Estadoactivacion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Estadoactivacion merge(Estadoactivacion detachedInstance) {
		log.debug("merging Estadoactivacion instance");
		try {
			Estadoactivacion result = (Estadoactivacion) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Estadoactivacion findById(com.monedafrontera.dto.EstadoactivacionId id) {
		log.debug("getting Estadoactivacion instance with id: " + id);
		try {
			Estadoactivacion instance = (Estadoactivacion) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Estadoactivacion", id);
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

	public List findByExample(Estadoactivacion instance) {
		log.debug("finding Estadoactivacion instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Estadoactivacion")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
