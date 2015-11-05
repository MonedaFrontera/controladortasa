package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Activacion;

/**
 * Home object for domain model class Activacion.
 * @see com.monedafrontera.dto.Activacion
 * @author Hibernate Tools
 */
public class ActivacionHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(ActivacionHome.class);


	public void persist(Activacion transientInstance) {
		log.debug("persisting Activacion instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Activacion instance) {
		log.debug("attaching dirty Activacion instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Activacion instance) {
		log.debug("attaching clean Activacion instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Activacion persistentInstance) {
		log.debug("deleting Activacion instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Activacion merge(Activacion detachedInstance) {
		log.debug("merging Activacion instance");
		try {
			Activacion result = (Activacion) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Activacion findById(int id) {
		log.debug("getting Activacion instance with id: " + id);
		try {
			Activacion instance = (Activacion) this.getSession()
					.get("com.monedafrontera.dto.Activacion", id);
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

	public List findByExample(Activacion instance) {
		log.debug("finding Activacion instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Activacion")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
