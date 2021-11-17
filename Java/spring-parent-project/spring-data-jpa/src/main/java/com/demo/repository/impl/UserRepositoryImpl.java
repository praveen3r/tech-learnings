package com.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.entity.User;
import com.demo.repository.UserRepositoryCustom;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@PersistenceContext(unitName="defaultUnit")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchResults(User user) throws Exception {
		List<User> queryResult = null;
		try {
			final StringBuilder queryStr = new StringBuilder("select new com.demo.entity.User(u.userName) from User u WHERE 1=1 ");

			if (null != user.getId()) {
				queryStr.append("AND u.id = :id ");
			}
			if (null != user.getPwd()) {
				queryStr.append("AND u.userName = :userName ");
			}
			if (null != user.getUserName()) {
				queryStr.append("AND u.pwd = :pwd ");
			}
			
			
			Query query = em.createQuery(queryStr.toString());
			
			if (null != user.getId()) {
				query.setParameter("id", user.getId());
			}
			if (null != user.getUserName()) {
				query.setParameter("userName", user.getUserName());
			}
			if (null != user.getPwd()) {
				query.setParameter("pwd", user.getPwd());
			}
			
			queryResult = (List<User>)  query.getResultList();
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return queryResult;
	}
}
