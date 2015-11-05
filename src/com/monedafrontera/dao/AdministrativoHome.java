package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Administrativo;

/**
 * Home object for domain model class Administrativo.
 * @see com.monedafrontera.dto.Administrativo
 * @author Hibernate Tools
 */
public class AdministrativoHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AdministrativoHome.class);

	
	public void persist(Administrativo transientInstance) {
		log.debug("persisting Administrativo instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrativo instance) {
		log.debug("attaching dirty Administrativo instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrativo instance) {
		log.debug("attaching clean Administrativo instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Administrativo persistentInstance) {
		log.debug("deleting Administrativo instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrativo merge(Administrativo detachedInstance) {
		log.debug("merging Administrativo instance");
		try {
			Administrativo result = (Administrativo) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Administrativo findById(java.lang.String id) {
		log.debug("getting Administrativo instance with id: " + id);
		try {
			Administrativo instance = (Administrativo) this.getSession()
					.get("com.monedafrontera.dto.Administrativo", id);
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

	public List findByExample(Administrativo instance) {
		log.debug("finding Administrativo instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Administrativo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
