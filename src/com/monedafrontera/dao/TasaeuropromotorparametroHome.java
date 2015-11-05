package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasaeuropromotorparametro;

/**
 * Home object for domain model class Tasaeuropromotorparametro.
 * @see com.monedafrontera.dto.Tasaeuropromotorparametro
 * @author Hibernate Tools
 */
public class TasaeuropromotorparametroHome {

	private static final Log log = LogFactory.getLog(TasaeuropromotorparametroHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasaeuropromotorparametro transientInstance) {
		log.debug("persisting Tasaeuropromotorparametro instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasaeuropromotorparametro instance) {
		log.debug("attaching dirty Tasaeuropromotorparametro instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasaeuropromotorparametro instance) {
		log.debug("attaching clean Tasaeuropromotorparametro instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasaeuropromotorparametro persistentInstance) {
		log.debug("deleting Tasaeuropromotorparametro instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasaeuropromotorparametro merge(Tasaeuropromotorparametro detachedInstance) {
		log.debug("merging Tasaeuropromotorparametro instance");
		try {
			Tasaeuropromotorparametro result = (Tasaeuropromotorparametro) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasaeuropromotorparametro findById(int id) {
		log.debug("getting Tasaeuropromotorparametro instance with id: " + id);
		try {
			Tasaeuropromotorparametro instance = (Tasaeuropromotorparametro) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasaeuropromotorparametro", id);
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

	public List findByExample(Tasaeuropromotorparametro instance) {
		log.debug("finding Tasaeuropromotorparametro instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasaeuropromotorparametro").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
