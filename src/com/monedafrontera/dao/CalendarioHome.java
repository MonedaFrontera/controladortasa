package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Calendario;

/**
 * Home object for domain model class Calendario.
 * @see com.monedafrontera.dto.Calendario
 * @author Hibernate Tools
 */
public class CalendarioHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(CalendarioHome.class);

	public void persist(Calendario transientInstance) {
		log.debug("persisting Calendario instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Calendario instance) {
		log.debug("attaching dirty Calendario instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Calendario instance) {
		log.debug("attaching clean Calendario instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Calendario persistentInstance) {
		log.debug("deleting Calendario instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Calendario merge(Calendario detachedInstance) {
		log.debug("merging Calendario instance");
		try {
			Calendario result = (Calendario) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Calendario findById(java.util.Date id) {
		log.debug("getting Calendario instance with id: " + id);
		try {
			Calendario instance = (Calendario) this.getSession()
					.get("com.monedafrontera.dto.Calendario", id);
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

	public List findByExample(Calendario instance) {
		log.debug("finding Calendario instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Calendario")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
