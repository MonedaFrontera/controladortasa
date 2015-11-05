package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Bancobin;

/**
 * Home object for domain model class Bancobin.
 * @see com.monedafrontera.dto.Bancobin
 * @author Hibernate Tools
 */
public class BancobinHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(BancobinHome.class);


	public void persist(Bancobin transientInstance) {
		log.debug("persisting Bancobin instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Bancobin instance) {
		log.debug("attaching dirty Bancobin instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bancobin instance) {
		log.debug("attaching clean Bancobin instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Bancobin persistentInstance) {
		log.debug("deleting Bancobin instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bancobin merge(Bancobin detachedInstance) {
		log.debug("merging Bancobin instance");
		try {
			Bancobin result = (Bancobin) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bancobin findById(java.lang.String id) {
		log.debug("getting Bancobin instance with id: " + id);
		try {
			Bancobin instance = (Bancobin) this.getSession().get("com.monedafrontera.dto.Bancobin",
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

	public List findByExample(Bancobin instance) {
		log.debug("finding Bancobin instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Bancobin")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
