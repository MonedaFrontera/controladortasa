package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Bloqueotarjeta;

/**
 * Home object for domain model class Bloqueotarjeta.
 * @see com.monedafrontera.dto.Bloqueotarjeta
 * @author Hibernate Tools
 */
public class BloqueotarjetaHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(BloqueotarjetaHome.class);


	public void persist(Bloqueotarjeta transientInstance) {
		log.debug("persisting Bloqueotarjeta instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Bloqueotarjeta instance) {
		log.debug("attaching dirty Bloqueotarjeta instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bloqueotarjeta instance) {
		log.debug("attaching clean Bloqueotarjeta instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Bloqueotarjeta persistentInstance) {
		log.debug("deleting Bloqueotarjeta instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bloqueotarjeta merge(Bloqueotarjeta detachedInstance) {
		log.debug("merging Bloqueotarjeta instance");
		try {
			Bloqueotarjeta result = (Bloqueotarjeta) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Bloqueotarjeta findById(int id) {
		log.debug("getting Bloqueotarjeta instance with id: " + id);
		try {
			Bloqueotarjeta instance = (Bloqueotarjeta) this.getSession()
					.get("com.monedafrontera.dto.Bloqueotarjeta", id);
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

	public List findByExample(Bloqueotarjeta instance) {
		log.debug("finding Bloqueotarjeta instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Bloqueotarjeta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
