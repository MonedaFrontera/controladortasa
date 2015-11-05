package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasadolarbancopais;
import com.monedafrontera.dto.TasadolarbancopaisId;

/**
 * Home object for domain model class Tasadolarbancopais.
 * @see com.monedafrontera.dto.Tasadolarbancopais
 * @author Hibernate Tools
 */
public class TasadolarbancopaisHome {

	private static final Log log = LogFactory.getLog(TasadolarbancopaisHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasadolarbancopais transientInstance) {
		log.debug("persisting Tasadolarbancopais instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasadolarbancopais instance) {
		log.debug("attaching dirty Tasadolarbancopais instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasadolarbancopais instance) {
		log.debug("attaching clean Tasadolarbancopais instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasadolarbancopais persistentInstance) {
		log.debug("deleting Tasadolarbancopais instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasadolarbancopais merge(Tasadolarbancopais detachedInstance) {
		log.debug("merging Tasadolarbancopais instance");
		try {
			Tasadolarbancopais result = (Tasadolarbancopais) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasadolarbancopais findById(com.monedafrontera.dto.TasadolarbancopaisId id) {
		log.debug("getting Tasadolarbancopais instance with id: " + id);
		try {
			Tasadolarbancopais instance = (Tasadolarbancopais) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasadolarbancopais", id);
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

	public List findByExample(Tasadolarbancopais instance) {
		log.debug("finding Tasadolarbancopais instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasadolarbancopais").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
