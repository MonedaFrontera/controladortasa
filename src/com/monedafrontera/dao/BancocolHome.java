package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Bancocol;

/**
 * Home object for domain model class Bancocol.
 * @see com.monedafrontera.dto.Bancocol
 * @author Hibernate Tools
 */
public class BancocolHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(BancocolHome.class);

	public void persist(Bancocol transientInstance) {
		log.debug("persisting Bancocol instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Bancocol instance) {
		log.debug("attaching dirty Bancocol instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bancocol instance) {
		log.debug("attaching clean Bancocol instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Bancocol persistentInstance) {
		log.debug("deleting Bancocol instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bancocol merge(Bancocol detachedInstance) {
		log.debug("merging Bancocol instance");
		try {
			Bancocol result = (Bancocol) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bancocol findById(java.lang.String id) {
		log.debug("getting Bancocol instance with id: " + id);
		try {
			Bancocol instance = (Bancocol) this.getSession().get("com.monedafrontera.dto.Bancocol",
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

	public List findByExample(Bancocol instance) {
		log.debug("finding Bancocol instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Bancocol")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
