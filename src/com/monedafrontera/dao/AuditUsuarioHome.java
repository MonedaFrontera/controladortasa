package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditUsuario;
import com.monedafrontera.dto.AuditUsuarioId;

/**
 * Home object for domain model class AuditUsuario.
 * @see com.monedafrontera.dto.AuditUsuario
 * @author Hibernate Tools
 */
public class AuditUsuarioHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AuditUsuarioHome.class);


	public void persist(AuditUsuario transientInstance) {
		log.debug("persisting AuditUsuario instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditUsuario instance) {
		log.debug("attaching dirty AuditUsuario instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditUsuario instance) {
		log.debug("attaching clean AuditUsuario instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditUsuario persistentInstance) {
		log.debug("deleting AuditUsuario instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditUsuario merge(AuditUsuario detachedInstance) {
		log.debug("merging AuditUsuario instance");
		try {
			AuditUsuario result = (AuditUsuario) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditUsuario findById(com.monedafrontera.dto.AuditUsuarioId id) {
		log.debug("getting AuditUsuario instance with id: " + id);
		try {
			AuditUsuario instance = (AuditUsuario) this.getSession()
					.get("com.monedafrontera.dto.AuditUsuario", id);
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

	public List findByExample(AuditUsuario instance) {
		log.debug("finding AuditUsuario instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.AuditUsuario")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
