package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Agencia;

/**
 * Home object for domain model class Agencia.
 * @see com.monedafrontera.dto.Agencia
 * @author Hibernate Tools
 */
public class AgenciaHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(AgenciaHome.class);

	public void persist(Agencia transientInstance) {
		log.debug("persisting Agencia instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Agencia instance) {
		log.debug("attaching dirty Agencia instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Agencia instance) {
		log.debug("attaching clean Agencia instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Agencia persistentInstance) {
		log.debug("deleting Agencia instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Agencia merge(Agencia detachedInstance) {
		log.debug("merging Agencia instance");
		try {
			Agencia result = (Agencia) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Agencia findById(java.lang.String id) {
		log.debug("getting Agencia instance with id: " + id);
		try {
			Agencia instance = (Agencia) this.getSession().get("com.monedafrontera.dto.Agencia", id);
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

	public List findByExample(Agencia instance) {
		log.debug("finding Agencia instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Agencia")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
