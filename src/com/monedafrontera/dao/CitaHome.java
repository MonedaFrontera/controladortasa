package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Cita;
import com.monedafrontera.dto.CitaId;

/**
 * Home object for domain model class Cita.
 * @see com.monedafrontera.dto.Cita
 * @author Hibernate Tools
 */
public class CitaHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(CitaHome.class);

	public void persist(Cita transientInstance) {
		log.debug("persisting Cita instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Cita instance) {
		log.debug("attaching dirty Cita instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cita instance) {
		log.debug("attaching clean Cita instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Cita persistentInstance) {
		log.debug("deleting Cita instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cita merge(Cita detachedInstance) {
		log.debug("merging Cita instance");
		try {
			Cita result = (Cita) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cita findById(com.monedafrontera.dto.CitaId id) {
		log.debug("getting Cita instance with id: " + id);
		try {
			Cita instance = (Cita) this.getSession().get("com.monedafrontera.dto.Cita", id);
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

	public List findByExample(Cita instance) {
		log.debug("finding Cita instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Cita")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
