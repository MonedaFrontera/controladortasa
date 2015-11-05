package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditViaje;
import com.monedafrontera.dto.AuditViajeId;

/**
 * Home object for domain model class AuditViaje.
 * @see com.monedafrontera.dto.AuditViaje
 * @author Hibernate Tools
 */
public class AuditViajeHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AuditViajeHome.class);

	public void persist(AuditViaje transientInstance) {
		log.debug("persisting AuditViaje instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditViaje instance) {
		log.debug("attaching dirty AuditViaje instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditViaje instance) {
		log.debug("attaching clean AuditViaje instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditViaje persistentInstance) {
		log.debug("deleting AuditViaje instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditViaje merge(AuditViaje detachedInstance) {
		log.debug("merging AuditViaje instance");
		try {
			AuditViaje result = (AuditViaje) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditViaje findById(com.monedafrontera.dto.AuditViajeId id) {
		log.debug("getting AuditViaje instance with id: " + id);
		try {
			AuditViaje instance = (AuditViaje) this.getSession()
					.get("com.monedafrontera.dto.AuditViaje", id);
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

	public List findByExample(AuditViaje instance) {
		log.debug("finding AuditViaje instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.AuditViaje")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
