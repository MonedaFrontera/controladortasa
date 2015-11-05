package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasadolarparametros;
import com.monedafrontera.dto.TasadolarparametrosId;

/**
 * Home object for domain model class Tasadolarparametros.
 * @see com.monedafrontera.dto.Tasadolarparametros
 * @author Hibernate Tools
 */
public class TasadolarparametrosHome {

	private static final Log log = LogFactory.getLog(TasadolarparametrosHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasadolarparametros transientInstance) {
		log.debug("persisting Tasadolarparametros instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasadolarparametros instance) {
		log.debug("attaching dirty Tasadolarparametros instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasadolarparametros instance) {
		log.debug("attaching clean Tasadolarparametros instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasadolarparametros persistentInstance) {
		log.debug("deleting Tasadolarparametros instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasadolarparametros merge(Tasadolarparametros detachedInstance) {
		log.debug("merging Tasadolarparametros instance");
		try {
			Tasadolarparametros result = (Tasadolarparametros) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasadolarparametros findById(com.monedafrontera.dto.TasadolarparametrosId id) {
		log.debug("getting Tasadolarparametros instance with id: " + id);
		try {
			Tasadolarparametros instance = (Tasadolarparametros) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasadolarparametros", id);
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

	public List findByExample(Tasadolarparametros instance) {
		log.debug("finding Tasadolarparametros instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasadolarparametros").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
