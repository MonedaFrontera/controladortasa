package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistasaldoviernes;
import com.monedafrontera.dto.VistasaldoviernesId;

/**
 * Home object for domain model class Vistasaldoviernes.
 * @see com.monedafrontera.dto.Vistasaldoviernes
 * @author Hibernate Tools
 */
public class VistasaldoviernesHome {

	private static final Log log = LogFactory.getLog(VistasaldoviernesHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistasaldoviernes transientInstance) {
		log.debug("persisting Vistasaldoviernes instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistasaldoviernes instance) {
		log.debug("attaching dirty Vistasaldoviernes instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistasaldoviernes instance) {
		log.debug("attaching clean Vistasaldoviernes instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistasaldoviernes persistentInstance) {
		log.debug("deleting Vistasaldoviernes instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistasaldoviernes merge(Vistasaldoviernes detachedInstance) {
		log.debug("merging Vistasaldoviernes instance");
		try {
			Vistasaldoviernes result = (Vistasaldoviernes) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistasaldoviernes findById(com.monedafrontera.dto.VistasaldoviernesId id) {
		log.debug("getting Vistasaldoviernes instance with id: " + id);
		try {
			Vistasaldoviernes instance = (Vistasaldoviernes) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistasaldoviernes", id);
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

	public List findByExample(Vistasaldoviernes instance) {
		log.debug("finding Vistasaldoviernes instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistasaldoviernes")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
