package com.demo.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public abstract class BaseRepositoryDAO<T, ID extends Serializable> implements BaseRepository<T, ID> {

	private final Class<T> persistentClass;

	//protected Session session;
	
	@Autowired
	@Qualifier("sessionFactory")
	protected SessionFactory sessionFactory;

	public BaseRepositoryDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	public void rollBackTransaction(final Transaction transaction) {
		if (transaction != null) {
			transaction.rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			final List<T> criteriaList = criteria.list();
			transaction.commit();
			return criteriaList;
		} catch (final Exception exp) {
			rollBackTransaction(transaction);
			throw exp;
		} finally {
			if (newSession != null) {
				if (newSession.isOpen()) {
					newSession.close();
				}
			}
		}
	}
	
	public List<T> makePersistent(final List<T> entityList) throws Exception {
		final List<T> modifiedEntities = new ArrayList<T>();
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction = newSession.beginTransaction();
			for (final T entity : entityList) {
				newSession.saveOrUpdate(entity);
				modifiedEntities.add(entity);
			}
			transaction.commit();
		} catch (final Exception exp) {
			rollBackTransaction(transaction);
			throw exp;
		} finally {
			if (newSession != null) {
				if (newSession.isOpen()) {
					newSession.close();
				}
			}
		}
		return modifiedEntities;
	}

}
