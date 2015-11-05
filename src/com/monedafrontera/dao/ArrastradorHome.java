package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Arrastrador;

/**
 * Home object for domain model class Arrastrador.
 * @see com.monedafrontera.dto.Arrastrador
 * @author Hibernate Tools
 */
public class ArrastradorHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(ArrastradorHome.class);

	public void persist(Arrastrador transientInstance) {
		log.debug("persisting Arrastrador instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Arrastrador instance) {
		log.debug("attaching dirty Arrastrador instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Arrastrador instance) {
		log.debug("attaching clean Arrastrador instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Arrastrador persistentInstance) {
		log.debug("deleting Arrastrador instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Arrastrador merge(Arrastrador detachedInstance) {
		log.debug("merging Arrastrador instance");
		try {
			Arrastrador result = (Arrastrador) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Arrastrador findById(java.lang.String id) {
		log.debug("getting Arrastrador instance with id: " + id);
		try {
			Arrastrador instance = (Arrastrador) this.getSession()
					.get("com.monedafrontera.dto.Arrastrador", id);
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

	public List findByExample(Arrastrador instance) {
		log.debug("finding Arrastrador instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Arrastrador")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
