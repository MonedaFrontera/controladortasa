package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasadolarpromotorparametro;

/**
 * Home object for domain model class Tasadolarpromotorparametro.
 * @see com.monedafrontera.dto.Tasadolarpromotorparametro
 * @author Hibernate Tools
 */
public class TasadolarpromotorparametroHome extends BaseHibernateDAO{

	private static final Log log = LogFactory.getLog(TasadolarpromotorparametroHome.class);


	public void persist(Tasadolarpromotorparametro transientInstance) {
		log.debug("persisting Tasadolarpromotorparametro instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasadolarpromotorparametro instance) {
		log.debug("attaching dirty Tasadolarpromotorparametro instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasadolarpromotorparametro instance) {
		log.debug("attaching clean Tasadolarpromotorparametro instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasadolarpromotorparametro persistentInstance) {
		log.debug("deleting Tasadolarpromotorparametro instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasadolarpromotorparametro merge(Tasadolarpromotorparametro detachedInstance) {
		log.debug("merging Tasadolarpromotorparametro instance");
		try {
			Tasadolarpromotorparametro result = (Tasadolarpromotorparametro) this.getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasadolarpromotorparametro findById(int id) {
		log.debug("getting Tasadolarpromotorparametro instance with id: " + id);
		try {
			Tasadolarpromotorparametro instance = (Tasadolarpromotorparametro) this.getSession()
					.get("com.monedafrontera.dto.Tasadolarpromotorparametro", id);
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

	public List findByExample(Tasadolarpromotorparametro instance) {
		log.debug("finding Tasadolarpromotorparametro instance by example");
		try {
			List results = this.getSession()
					.createCriteria("com.monedafrontera.dto.Tasadolarpromotorparametro").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
