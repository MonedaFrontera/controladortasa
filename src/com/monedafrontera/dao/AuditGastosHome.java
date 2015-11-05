package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditGastos;
import com.monedafrontera.dto.AuditGastosId;

/**
 * Home object for domain model class AuditGastos.
 * @see com.monedafrontera.dto.AuditGastos
 * @author Hibernate Tools
 */
public class AuditGastosHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AuditGastosHome.class);

	public void persist(AuditGastos transientInstance) {
		log.debug("persisting AuditGastos instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditGastos instance) {
		log.debug("attaching dirty AuditGastos instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditGastos instance) {
		log.debug("attaching clean AuditGastos instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditGastos persistentInstance) {
		log.debug("deleting AuditGastos instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditGastos merge(AuditGastos detachedInstance) {
		log.debug("merging AuditGastos instance");
		try {
			AuditGastos result = (AuditGastos) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditGastos findById(com.monedafrontera.dto.AuditGastosId id) {
		log.debug("getting AuditGastos instance with id: " + id);
		try {
			AuditGastos instance = (AuditGastos) this.getSession()
					.get("com.monedafrontera.dto.AuditGastos", id);
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

	public List findByExample(AuditGastos instance) {
		log.debug("finding AuditGastos instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.AuditGastos")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
