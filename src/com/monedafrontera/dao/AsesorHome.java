package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Asesor;

/**
 * Home object for domain model class Asesor.
 * @see com.monedafrontera.dto.Asesor
 * @author Hibernate Tools
 */
public class AsesorHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AsesorHome.class);


	public void persist(Asesor transientInstance) {
		log.debug("persisting Asesor instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Asesor instance) {
		log.debug("attaching dirty Asesor instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Asesor instance) {
		log.debug("attaching clean Asesor instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Asesor persistentInstance) {
		log.debug("deleting Asesor instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Asesor merge(Asesor detachedInstance) {
		log.debug("merging Asesor instance");
		try {
			Asesor result = (Asesor) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Asesor findById(java.lang.String id) {
		log.debug("getting Asesor instance with id: " + id);
		try {
			Asesor instance = (Asesor) this.getSession().get("com.monedafrontera.dto.Asesor", id);
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

	public List findByExample(Asesor instance) {
		log.debug("finding Asesor instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Asesor")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
