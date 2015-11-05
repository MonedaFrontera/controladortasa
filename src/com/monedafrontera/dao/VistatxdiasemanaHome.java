package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistatxdiasemana;
import com.monedafrontera.dto.VistatxdiasemanaId;

/**
 * Home object for domain model class Vistatxdiasemana.
 * @see com.monedafrontera.dto.Vistatxdiasemana
 * @author Hibernate Tools
 */
public class VistatxdiasemanaHome {

	private static final Log log = LogFactory.getLog(VistatxdiasemanaHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistatxdiasemana transientInstance) {
		log.debug("persisting Vistatxdiasemana instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistatxdiasemana instance) {
		log.debug("attaching dirty Vistatxdiasemana instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistatxdiasemana instance) {
		log.debug("attaching clean Vistatxdiasemana instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistatxdiasemana persistentInstance) {
		log.debug("deleting Vistatxdiasemana instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistatxdiasemana merge(Vistatxdiasemana detachedInstance) {
		log.debug("merging Vistatxdiasemana instance");
		try {
			Vistatxdiasemana result = (Vistatxdiasemana) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistatxdiasemana findById(com.monedafrontera.dto.VistatxdiasemanaId id) {
		log.debug("getting Vistatxdiasemana instance with id: " + id);
		try {
			Vistatxdiasemana instance = (Vistatxdiasemana) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistatxdiasemana", id);
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

	public List findByExample(Vistatxdiasemana instance) {
		log.debug("finding Vistatxdiasemana instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistatxdiasemana")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
