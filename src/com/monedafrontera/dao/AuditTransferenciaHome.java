package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.AuditTransferencia;
import com.monedafrontera.dto.AuditTransferenciaId;

/**
 * Home object for domain model class AuditTransferencia.
 * @see com.monedafrontera.dto.AuditTransferencia
 * @author Hibernate Tools
 */
public class AuditTransferenciaHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(AuditTransferenciaHome.class);

	public void persist(AuditTransferencia transientInstance) {
		log.debug("persisting AuditTransferencia instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AuditTransferencia instance) {
		log.debug("attaching dirty AuditTransferencia instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AuditTransferencia instance) {
		log.debug("attaching clean AuditTransferencia instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AuditTransferencia persistentInstance) {
		log.debug("deleting AuditTransferencia instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AuditTransferencia merge(AuditTransferencia detachedInstance) {
		log.debug("merging AuditTransferencia instance");
		try {
			AuditTransferencia result = (AuditTransferencia) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AuditTransferencia findById(com.monedafrontera.dto.AuditTransferenciaId id) {
		log.debug("getting AuditTransferencia instance with id: " + id);
		try {
			AuditTransferencia instance = (AuditTransferencia) this.getSession()
					.get("com.monedafrontera.dto.AuditTransferencia", id);
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

	public List findByExample(AuditTransferencia instance) {
		log.debug("finding AuditTransferencia instance by example");
		try {
			List results = this.getSession()
					.createCriteria("com.monedafrontera.dto.AuditTransferencia").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
