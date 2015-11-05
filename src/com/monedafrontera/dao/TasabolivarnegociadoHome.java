package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Tasabolivarnegociado;
import com.monedafrontera.dto.TasabolivarnegociadoId;

/**
 * Home object for domain model class Tasabolivarnegociado.
 * @see com.monedafrontera.dto.Tasabolivarnegociado
 * @author Hibernate Tools
 */
public class TasabolivarnegociadoHome {

	private static final Log log = LogFactory.getLog(TasabolivarnegociadoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Tasabolivarnegociado transientInstance) {
		log.debug("persisting Tasabolivarnegociado instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Tasabolivarnegociado instance) {
		log.debug("attaching dirty Tasabolivarnegociado instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tasabolivarnegociado instance) {
		log.debug("attaching clean Tasabolivarnegociado instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Tasabolivarnegociado persistentInstance) {
		log.debug("deleting Tasabolivarnegociado instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tasabolivarnegociado merge(Tasabolivarnegociado detachedInstance) {
		log.debug("merging Tasabolivarnegociado instance");
		try {
			Tasabolivarnegociado result = (Tasabolivarnegociado) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tasabolivarnegociado findById(com.monedafrontera.dto.TasabolivarnegociadoId id) {
		log.debug("getting Tasabolivarnegociado instance with id: " + id);
		try {
			Tasabolivarnegociado instance = (Tasabolivarnegociado) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Tasabolivarnegociado", id);
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

	public List findByExample(Tasabolivarnegociado instance) {
		log.debug("finding Tasabolivarnegociado instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.monedafrontera.dto.Tasabolivarnegociado").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
