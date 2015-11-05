package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Personal;

/**
 * Home object for domain model class Personal.
 * @see com.monedafrontera.dto.Personal
 * @author Hibernate Tools
 */
public class PersonalHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(PersonalHome.class);


	public void persist(Personal transientInstance) {
		log.debug("persisting Personal instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Personal instance) {
		log.debug("attaching dirty Personal instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Personal instance) {
		log.debug("attaching clean Personal instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Personal persistentInstance) {
		log.debug("deleting Personal instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Personal merge(Personal detachedInstance) {
		log.debug("merging Personal instance");
		try {
			Personal result = (Personal) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Personal findById(java.lang.String id) {
		log.debug("getting Personal instance with id: " + id);
		try {
			Personal instance = (Personal) this.getSession().get("com.monedafrontera.dto.Personal",
					id);
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

	public List findByExample(Personal instance) {
		log.debug("finding Personal instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Personal")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
