package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Actestado;

/**
 * Home object for domain model class Actestado.
 * @see com.monedafrontera.dto.Actestado
 * @author Hibernate Tools
 */
public class ActestadoHome extends BaseHibernateDAO  {

	private static final Log log = LogFactory.getLog(ActestadoHome.class);

	

	public void persist(Actestado transientInstance) {
		log.debug("persisting Actestado instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Actestado instance) {
		log.debug("attaching dirty Actestado instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Actestado instance) {
		log.debug("attaching clean Actestado instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Actestado persistentInstance) {
		log.debug("deleting Actestado instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Actestado merge(Actestado detachedInstance) {
		log.debug("merging Actestado instance");
		try {
			Actestado result = (Actestado) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Actestado findById(java.lang.String id) {
		log.debug("getting Actestado instance with id: " + id);
		try {
			Actestado instance = (Actestado) this.getSession().get("com.monedafrontera.dto.Actestado",
					id);
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

	public List findByExample(Actestado instance) {
		log.debug("finding Actestado instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Actestado")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
