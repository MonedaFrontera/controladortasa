package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistasaldodiariopromotor;
import com.monedafrontera.dto.VistasaldodiariopromotorId;

/**
 * Home object for domain model class Vistasaldodiariopromotor.
 * @see com.monedafrontera.dto.Vistasaldodiariopromotor
 * @author Hibernate Tools
 */
public class VistasaldodiariopromotorHome {

	private static final Log log = LogFactory.getLog(VistasaldodiariopromotorHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistasaldodiariopromotor transientInstance) {
		log.debug("persisting Vistasaldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistasaldodiariopromotor instance) {
		log.debug("attaching dirty Vistasaldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistasaldodiariopromotor instance) {
		log.debug("attaching clean Vistasaldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistasaldodiariopromotor persistentInstance) {
		log.debug("deleting Vistasaldodiariopromotor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistasaldodiariopromotor merge(Vistasaldodiariopromotor detachedInstance) {
		log.debug("merging Vistasaldodiariopromotor instance");
		try {
			Vistasaldodiariopromotor result = (Vistasaldodiariopromotor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistasaldodiariopromotor findById(com.monedafrontera.dto.VistasaldodiariopromotorId id) {
		log.debug("getting Vistasaldodiariopromotor instance with id: " + id);
		try {
			Vistasaldodiariopromotor instance = (Vistasaldodiariopromotor) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistasaldodiariopromotor", id);
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

	public List findByExample(Vistasaldodiariopromotor instance) {
		log.debug("finding Vistasaldodiariopromotor instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Vistasaldodiariopromotor").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
