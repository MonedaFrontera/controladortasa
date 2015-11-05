package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistasaldolunes;
import com.monedafrontera.dto.VistasaldolunesId;

/**
 * Home object for domain model class Vistasaldolunes.
 * @see com.monedafrontera.dto.Vistasaldolunes
 * @author Hibernate Tools
 */
public class VistasaldolunesHome {

	private static final Log log = LogFactory.getLog(VistasaldolunesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistasaldolunes transientInstance) {
		log.debug("persisting Vistasaldolunes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistasaldolunes instance) {
		log.debug("attaching dirty Vistasaldolunes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistasaldolunes instance) {
		log.debug("attaching clean Vistasaldolunes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistasaldolunes persistentInstance) {
		log.debug("deleting Vistasaldolunes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistasaldolunes merge(Vistasaldolunes detachedInstance) {
		log.debug("merging Vistasaldolunes instance");
		try {
			Vistasaldolunes result = (Vistasaldolunes) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistasaldolunes findById(com.monedafrontera.dto.VistasaldolunesId id) {
		log.debug("getting Vistasaldolunes instance with id: " + id);
		try {
			Vistasaldolunes instance = (Vistasaldolunes) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistasaldolunes", id);
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

	public List findByExample(Vistasaldolunes instance) {
		log.debug("finding Vistasaldolunes instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistasaldolunes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
