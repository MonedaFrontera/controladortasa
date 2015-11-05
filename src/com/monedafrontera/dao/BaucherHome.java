package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Baucher;
import com.monedafrontera.dto.BaucherId;

/**
 * Home object for domain model class Baucher.
 * @see com.monedafrontera.dto.Baucher
 * @author Hibernate Tools
 */
public class BaucherHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(BaucherHome.class);


	public void persist(Baucher transientInstance) {
		log.debug("persisting Baucher instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Baucher instance) {
		log.debug("attaching dirty Baucher instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Baucher instance) {
		log.debug("attaching clean Baucher instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Baucher persistentInstance) {
		log.debug("deleting Baucher instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Baucher merge(Baucher detachedInstance) {
		log.debug("merging Baucher instance");
		try {
			Baucher result = (Baucher) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Baucher findById(com.monedafrontera.dto.BaucherId id) {
		log.debug("getting Baucher instance with id: " + id);
		try {
			Baucher instance = (Baucher) this.getSession().get("com.monedafrontera.dto.Baucher", id);
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

	public List findByExample(Baucher instance) {
		log.debug("finding Baucher instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Baucher")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
