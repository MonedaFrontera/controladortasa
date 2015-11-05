package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Clasetarjeta;
import com.monedafrontera.dto.ClasetarjetaId;

/**
 * Home object for domain model class Clasetarjeta.
 * @see com.monedafrontera.dto.Clasetarjeta
 * @author Hibernate Tools
 */
public class ClasetarjetaHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(ClasetarjetaHome.class);

	public void persist(Clasetarjeta transientInstance) {
		log.debug("persisting Clasetarjeta instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Clasetarjeta instance) {
		log.debug("attaching dirty Clasetarjeta instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clasetarjeta instance) {
		log.debug("attaching clean Clasetarjeta instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Clasetarjeta persistentInstance) {
		log.debug("deleting Clasetarjeta instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clasetarjeta merge(Clasetarjeta detachedInstance) {
		log.debug("merging Clasetarjeta instance");
		try {
			Clasetarjeta result = (Clasetarjeta) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Clasetarjeta findById(com.monedafrontera.dto.ClasetarjetaId id) {
		log.debug("getting Clasetarjeta instance with id: " + id);
		try {
			Clasetarjeta instance = (Clasetarjeta) this.getSession()
					.get("com.monedafrontera.dto.Clasetarjeta", id);
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

	public List findByExample(Clasetarjeta instance) {
		log.debug("finding Clasetarjeta instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Clasetarjeta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
