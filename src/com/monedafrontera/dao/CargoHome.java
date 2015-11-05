package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Cargo;

/**
 * Home object for domain model class Cargo.
 * @see com.monedafrontera.dto.Cargo
 * @author Hibernate Tools
 */
public class CargoHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(CargoHome.class);


	public void persist(Cargo transientInstance) {
		log.debug("persisting Cargo instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cargo instance) {
		log.debug("attaching dirty Cargo instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cargo instance) {
		log.debug("attaching clean Cargo instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cargo persistentInstance) {
		log.debug("deleting Cargo instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cargo merge(Cargo detachedInstance) {
		log.debug("merging Cargo instance");
		try {
			Cargo result = (Cargo) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cargo findById(java.lang.String id) {
		log.debug("getting Cargo instance with id: " + id);
		try {
			Cargo instance = (Cargo) this.getSession().get("com.monedafrontera.dto.Cargo", id);
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

	public List findByExample(Cargo instance) {
		log.debug("finding Cargo instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Cargo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
