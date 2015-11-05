package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Banco;

/**
 * Home object for domain model class Banco.
 * @see com.monedafrontera.dto.Banco
 * @author Hibernate Tools
 */
public class BancoHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(BancoHome.class);


	public void persist(Banco transientInstance) {
		log.debug("persisting Banco instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Banco instance) {
		log.debug("attaching dirty Banco instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Banco instance) {
		log.debug("attaching clean Banco instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Banco persistentInstance) {
		log.debug("deleting Banco instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Banco merge(Banco detachedInstance) {
		log.debug("merging Banco instance");
		try {
			Banco result = (Banco) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Banco findById(java.lang.String id) {
		log.debug("getting Banco instance with id: " + id);
		try {
			Banco instance = (Banco) this.getSession().get("com.monedafrontera.dto.Banco", id);
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

	public List findByExample(Banco instance) {
		log.debug("finding Banco instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Banco")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
