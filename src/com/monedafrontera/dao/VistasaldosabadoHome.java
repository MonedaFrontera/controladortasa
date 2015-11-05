package com.monedafrontera.dao;
// Generated 5/11/2015 11:46:51 AM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.monedafrontera.dto.Vistasaldosabado;
import com.monedafrontera.dto.VistasaldosabadoId;

/**
 * Home object for domain model class Vistasaldosabado.
 * @see com.monedafrontera.dto.Vistasaldosabado
 * @author Hibernate Tools
 */
public class VistasaldosabadoHome {

	private static final Log log = LogFactory.getLog(VistasaldosabadoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Vistasaldosabado transientInstance) {
		log.debug("persisting Vistasaldosabado instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Vistasaldosabado instance) {
		log.debug("attaching dirty Vistasaldosabado instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vistasaldosabado instance) {
		log.debug("attaching clean Vistasaldosabado instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Vistasaldosabado persistentInstance) {
		log.debug("deleting Vistasaldosabado instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vistasaldosabado merge(Vistasaldosabado detachedInstance) {
		log.debug("merging Vistasaldosabado instance");
		try {
			Vistasaldosabado result = (Vistasaldosabado) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vistasaldosabado findById(com.monedafrontera.dto.VistasaldosabadoId id) {
		log.debug("getting Vistasaldosabado instance with id: " + id);
		try {
			Vistasaldosabado instance = (Vistasaldosabado) sessionFactory.getCurrentSession()
					.get("com.monedafrontera.dto.Vistasaldosabado", id);
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

	public List findByExample(Vistasaldosabado instance) {
		log.debug("finding Vistasaldosabado instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.monedafrontera.dto.Vistasaldosabado")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
