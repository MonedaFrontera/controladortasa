package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Porcentajebancopais;
import com.monedafrontera.dto.PorcentajebancopaisId;

/**
 * Home object for domain model class Porcentajebancopais.
 * @see com.monedafrontera.dto.Porcentajebancopais
 * @author Hibernate Tools
 */
public class PorcentajebancopaisHome {

	private static final Log log = LogFactory.getLog(PorcentajebancopaisHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Porcentajebancopais transientInstance) {
		log.debug("persisting Porcentajebancopais instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Porcentajebancopais instance) {
		log.debug("attaching dirty Porcentajebancopais instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Porcentajebancopais instance) {
		log.debug("attaching clean Porcentajebancopais instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Porcentajebancopais persistentInstance) {
		log.debug("deleting Porcentajebancopais instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Porcentajebancopais merge(Porcentajebancopais detachedInstance) {
		log.debug("merging Porcentajebancopais instance");
		try {
			Porcentajebancopais result = (Porcentajebancopais) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Porcentajebancopais findById(com.monedafrontera.dto.PorcentajebancopaisId id) {
		log.debug("getting Porcentajebancopais instance with id: " + id);
		try {
			Porcentajebancopais instance = (Porcentajebancopais) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Porcentajebancopais", id);
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

	public List findByExample(Porcentajebancopais instance) {
		log.debug("finding Porcentajebancopais instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Porcentajebancopais").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
