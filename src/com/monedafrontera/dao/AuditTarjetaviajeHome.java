package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditTarjetaviaje;
import com.monedafrontera.dto.AuditTarjetaviajeId;

/**
 * Home object for domain model class AuditTarjetaviaje.
 * @see com.monedafrontera.dto.AuditTarjetaviaje
 * @author Hibernate Tools
 */
public class AuditTarjetaviajeHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(AuditTarjetaviajeHome.class);


	public void persist(AuditTarjetaviaje transientInstance) {
		log.debug("persisting AuditTarjetaviaje instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditTarjetaviaje instance) {
		log.debug("attaching dirty AuditTarjetaviaje instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditTarjetaviaje instance) {
		log.debug("attaching clean AuditTarjetaviaje instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditTarjetaviaje persistentInstance) {
		log.debug("deleting AuditTarjetaviaje instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditTarjetaviaje merge(AuditTarjetaviaje detachedInstance) {
		log.debug("merging AuditTarjetaviaje instance");
		try {
			AuditTarjetaviaje result = (AuditTarjetaviaje) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditTarjetaviaje findById(com.monedafrontera.dto.AuditTarjetaviajeId id) {
		log.debug("getting AuditTarjetaviaje instance with id: " + id);
		try {
			AuditTarjetaviaje instance = (AuditTarjetaviaje) this.getSession()
					.get("com.monedafrontera.dto.AuditTarjetaviaje", id);
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

	public List findByExample(AuditTarjetaviaje instance) {
		log.debug("finding AuditTarjetaviaje instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.AuditTarjetaviaje")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
