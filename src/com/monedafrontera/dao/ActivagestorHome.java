package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Activagestor;
import com.monedafrontera.dto.ActivagestorId;

/**
 * Home object for domain model class Activagestor.
 * @see com.monedafrontera.dto.Activagestor
 * @author Hibernate Tools
 */
public class ActivagestorHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(ActivagestorHome.class);


	public void persist(Activagestor transientInstance) {
		log.debug("persisting Activagestor instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Activagestor instance) {
		log.debug("attaching dirty Activagestor instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Activagestor instance) {
		log.debug("attaching clean Activagestor instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Activagestor persistentInstance) {
		log.debug("deleting Activagestor instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Activagestor merge(Activagestor detachedInstance) {
		log.debug("merging Activagestor instance");
		try {
			Activagestor result = (Activagestor) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Activagestor findById(com.monedafrontera.dto.ActivagestorId id) {
		log.debug("getting Activagestor instance with id: " + id);
		try {
			Activagestor instance = (Activagestor) this.getSession()
					.get("com.monedafrontera.dto.Activagestor", id);
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

	public List findByExample(Activagestor instance) {
		log.debug("finding Activagestor instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Activagestor")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
