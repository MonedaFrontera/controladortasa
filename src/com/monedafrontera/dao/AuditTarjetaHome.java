package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditTarjeta;
import com.monedafrontera.dto.AuditTarjetaId;

/**
 * Home object for domain model class AuditTarjeta.
 * @see com.monedafrontera.dto.AuditTarjeta
 * @author Hibernate Tools
 */
public class AuditTarjetaHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AuditTarjetaHome.class);


	public void persist(AuditTarjeta transientInstance) {
		log.debug("persisting AuditTarjeta instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditTarjeta instance) {
		log.debug("attaching dirty AuditTarjeta instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditTarjeta instance) {
		log.debug("attaching clean AuditTarjeta instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditTarjeta persistentInstance) {
		log.debug("deleting AuditTarjeta instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditTarjeta merge(AuditTarjeta detachedInstance) {
		log.debug("merging AuditTarjeta instance");
		try {
			AuditTarjeta result = (AuditTarjeta) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditTarjeta findById(com.monedafrontera.dto.AuditTarjetaId id) {
		log.debug("getting AuditTarjeta instance with id: " + id);
		try {
			AuditTarjeta instance = (AuditTarjeta) this.getSession()
					.get("com.monedafrontera.dto.AuditTarjeta", id);
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

	public List findByExample(AuditTarjeta instance) {
		log.debug("finding AuditTarjeta instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.AuditTarjeta")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
