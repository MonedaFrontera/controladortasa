package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Banner;

/**
 * Home object for domain model class Banner.
 * @see com.monedafrontera.dto.Banner
 * @author Hibernate Tools
 */
public class BannerHome extends BaseHibernateDAO {

	private static final Log log = LogFactory.getLog(BannerHome.class);


	public void persist(Banner transientInstance) {
		log.debug("persisting Banner instance");
		try {
			this.getSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Banner instance) {
		log.debug("attaching dirty Banner instance");
		try {
			this.getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Banner instance) {
		log.debug("attaching clean Banner instance");
		try {
			this.getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Banner persistentInstance) {
		log.debug("deleting Banner instance");
		try {
			this.getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Banner merge(Banner detachedInstance) {
		log.debug("merging Banner instance");
		try {
			Banner result = (Banner) this.getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Banner findById(int id) {
		log.debug("getting Banner instance with id: " + id);
		try {
			Banner instance = (Banner) this.getSession().get("com.monedafrontera.dto.Banner", id);
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

	public List findByExample(Banner instance) {
		log.debug("finding Banner instance by example");
		try {
			List results = this.getSession().createCriteria("com.monedafrontera.dto.Banner")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
