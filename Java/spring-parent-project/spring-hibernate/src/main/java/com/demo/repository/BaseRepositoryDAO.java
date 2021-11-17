package com.demo.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.type.StandardBasicTypes;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
	/*public T findById(final ID id, final boolean lock) throws Exception {
		T entity;
		if (lock) {
			entity = (T)newSession.load(getPersistentClass(), id, LockMode.UPGRADE);
		} else {
			entity = (T)newSession.load(getPersistentClass(), id);
		}
		return entity;
	}*/

	public List<T> findAll() throws Exception {
		return findByCriteria();
	}

	public T makePersistent(final T entity) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			newSession.saveOrUpdate(entity);
			transaction.commit();
			return entity;
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

	public List<T> batchInsert(final List<T> entityList, final int batchSize) throws Exception {
		int index = 0;
		final List<T> modifiedEntities = new ArrayList<T>();
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction = newSession.beginTransaction();
			for (final T entity : entityList) {
				index++;
				newSession.save(entity);
				modifiedEntities.add(entity);
				if (index % batchSize == 0) {
					newSession.flush();
					newSession.clear();
					index = 0;
				}
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

	public List<T> batchUpdate(final List<T> entityList, final int batchSize) throws Exception {
		int index = 0;
		final List<T> modifiedEntities = new ArrayList<T>();
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction = newSession.beginTransaction();
			for (final T entity : entityList) {
				index++;
				newSession.update(entity);
				modifiedEntities.add(entity);
				if (index % batchSize == 0) {
					newSession.flush();
					newSession.clear();
					index = 0;
				}
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

	public List<T> batchDelete(final List<T> entityList, final int batchSize) throws Exception {
		int index = 0;
		final List<T> modifiedEntities = new ArrayList<T>();
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction = newSession.beginTransaction();
			for (final T entity : entityList) {
				index++;
				newSession.delete(entity);
				modifiedEntities.add(entity);
				if (index % batchSize == 0) {
					newSession.flush();
					newSession.clear();
					index = 0;
				}
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

	public void makeTransient(final T entity) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction = newSession.beginTransaction();
			newSession.delete(entity);
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
	}

	public int makeTransient(final List<T> entityList) throws Exception {
		int removedEntitiesCnt = 0;
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			for (final T entity : entityList) {
				newSession.delete(entity);
				removedEntitiesCnt++;
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
		return removedEntitiesCnt;
	}
	
	
	public T makePersistentSave(final T entity) throws Exception {
		try {
			if(sessionFactory.getCurrentSession() != null) {
				sessionFactory.getCurrentSession().save(entity);
			}
		} catch (final Exception exp) {
			
			throw exp;
		} 
		return entity;
	}
	
	public T makePersistentUpd(final T entity) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			newSession.update(entity);
			transaction.commit();
			return entity;
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
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(int firstResult, int maxResults, final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			criteria.setFirstResult(firstResult);
			criteria.setMaxResults(maxResults);
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
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriteriaAsc(final List<String> ascOrderFields, final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			if (ascOrderFields != null && ascOrderFields.size() > 0) {
				for (final String field : ascOrderFields) {
					criteria.addOrder(Order.asc(field));
				}
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
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriteriaDesc(final List<String> descOrderFields, final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			if (descOrderFields != null && descOrderFields.size() > 0) {
				for (final String field : descOrderFields) {
					criteria.addOrder(Order.desc(field));
				}
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
	
	@SuppressWarnings("unchecked")
	public Object findByCriteria(final ProjectionList projectionList, final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			criteria.setProjection(projectionList);
			final Object criteriaList = criteria.list();
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
	
	@SuppressWarnings("unchecked")
	public Object findByCriteria(final Object obj, final ProjectionList projectionList) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			criteria.add(Example.create(obj));
			criteria.setProjection(projectionList);
			final Object criteriaList = criteria.list();
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

	@SuppressWarnings("unchecked")
	public List<Object[]> findByCriteria(final ProjectionList projectionList) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			criteria.setProjection(projectionList);
			final List<Object[]> criteriaList = criteria.list();
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
	
	@SuppressWarnings("unchecked")
	public List<T> findByCriteriaCacheable(final Criterion... criterion) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());
			for (final Criterion c : criterion) {
				criteria.add(c);
			}
			criteria.setCacheable(true);
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

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final List<String> ascOrderFields, final List<String> descOrderFields) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Criteria criteria =newSession.createCriteria(getPersistentClass());

			if (ascOrderFields != null && ascOrderFields.size() > 0) {
				for (final String field : ascOrderFields) {
					criteria.addOrder(Order.asc(field));
				}
			}
			if (descOrderFields != null && descOrderFields.size() > 0) {
				for (final String field : descOrderFields) {
					criteria.addOrder(Order.desc(field));
				}
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

	@SuppressWarnings("unchecked")
	public List<T> findByHQL(final String hql) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final List<T> hqlList =newSession.createQuery(hql).list();
			transaction.commit();
			return hqlList;
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

	@SuppressWarnings("unchecked")
	public Long getCount(final String hql) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Long count = (Long)newSession.createQuery(hql).uniqueResult();
			transaction.commit();
			return count;
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

	@SuppressWarnings("unchecked")
	public List<T> batchFetch(final int fromRow, final int batchSize, final String hql) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final List<T> hqlList =newSession.createQuery(hql).setFirstResult(fromRow).setMaxResults(batchSize).list();
			transaction.commit();
			return hqlList;
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

	//Only for Oracle to retrieve sequence
	@SuppressWarnings("unchecked")
	public BigInteger getSequence(final String hql) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Query query =newSession.createSQLQuery(hql).addScalar("num", StandardBasicTypes.BIG_INTEGER);
			final BigInteger bigInt = (BigInteger) query.uniqueResult();
			transaction.commit();
			return bigInt;
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

	@SuppressWarnings("unchecked")
	public List<T> findByHQL(final String hql, final Map<String, Object> namedParameters) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Query query =newSession.createQuery(hql);
			if (namedParameters != null) {
				for (final Map.Entry<String, Object> meParam : namedParameters.entrySet()) {
					query.setParameter(meParam.getKey(), meParam.getValue());
				}
			}
			final List<T> hqlList = query.list();
			transaction.commit();
			return hqlList;
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
	@SuppressWarnings("unchecked")
	public List<T> findByHQLBlob(final String hql, final Map<String, Object> namedParameters) throws Exception {
		Transaction transaction = null;
		Session newSession = null;
		try {
			newSession= sessionFactory.openSession();
			transaction =newSession.beginTransaction();
			final Query query =newSession.createQuery(hql);
			if (namedParameters != null) {
				for (final Map.Entry<String, Object> meParam : namedParameters.entrySet()) {
					query.setParameter(meParam.getKey(), meParam.getValue());
				}
			}
			final List<T> hqlList = query.list();
			transaction.commit();
			return hqlList;
		} catch (final Exception exp) {
			rollBackTransaction(transaction);
			throw exp;
		} finally {
			if (newSession != null) {
				if (newSession.isOpen()) {
					//newSession.close();
				}
			}
		}
	}


}
