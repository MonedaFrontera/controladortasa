package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Comisionhistorico;
import com.monedafrontera.dto.ComisionhistoricoId;

/**
 * Home object for domain model class Comisionhistorico.
 * @see com.monedafrontera.dto.Comisionhistorico
 * @author Hibernate Tools
 */
public class ComisionhistoricoHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(ComisionhistoricoHome.class);


	public void persist(Comisionhistorico transientInstance) {
		log.debug("persisting Comisionhistorico instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Comisionhistorico instance) {
		log.debug("attaching dirty Comisionhistorico instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comisionhistorico instance) {
		log.debug("attaching clean Comisionhistorico instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Comisionhistorico persistentInstance) {
		log.debug("deleting Comisionhistorico instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comisionhistorico merge(Comisionhistorico detachedInstance) {
		log.debug("merging Comisionhistorico instance");
		try {
			Comisionhistorico result = (Comisionhistorico) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comisionhistorico findById(com.monedafrontera.dto.ComisionhistoricoId id) {
		log.debug("getting Comisionhistorico instance with id: " + id);
		try {
			Comisionhistorico instance = (Comisionhistorico) this.getSession()
					.get("com.monedafrontera.dto.Comisionhistorico", id);
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

	public List findByExample(Comisionhistorico instance) {
		log.debug("finding Comisionhistorico instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Comisionhistorico")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
