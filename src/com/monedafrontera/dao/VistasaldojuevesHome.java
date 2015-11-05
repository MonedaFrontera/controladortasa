package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistasaldojueves;
import com.monedafrontera.dto.VistasaldojuevesId;

/**
 * Home object for domain model class Vistasaldojueves.
 * @see com.monedafrontera.dto.Vistasaldojueves
 * @author Hibernate Tools
 */
public class VistasaldojuevesHome {

	private static final Log log = LogFactory.getLog(VistasaldojuevesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistasaldojueves transientInstance) {
		log.debug("persisting Vistasaldojueves instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistasaldojueves instance) {
		log.debug("attaching dirty Vistasaldojueves instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistasaldojueves instance) {
		log.debug("attaching clean Vistasaldojueves instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistasaldojueves persistentInstance) {
		log.debug("deleting Vistasaldojueves instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistasaldojueves merge(Vistasaldojueves detachedInstance) {
		log.debug("merging Vistasaldojueves instance");
		try {
			Vistasaldojueves result = (Vistasaldojueves) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistasaldojueves findById(com.monedafrontera.dto.VistasaldojuevesId id) {
		log.debug("getting Vistasaldojueves instance with id: " + id);
		try {
			Vistasaldojueves instance = (Vistasaldojueves) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistasaldojueves", id);
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

	public List findByExample(Vistasaldojueves instance) {
		log.debug("finding Vistasaldojueves instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistasaldojueves")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
