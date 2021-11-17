package com.demo.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.demo.entity.EmployeeResource;
import com.demo.entity.Project;
import com.demo.entity.User;

@Repository
public class UserRepositoryDAO extends BaseRepositoryDAO<User , Serializable> implements UserRepository{

	public List<User> getUsers(){
		List<User> userList = new ArrayList<>();
		try {
			final StringBuffer hql = new StringBuffer("FROM User");
			userList = findByHQL(hql.toString());
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return userList;
	}
	
	public List<User> getUsersWithNamedParam(){
		List<User> userList = new ArrayList<>();
		try {
			final StringBuffer hql = new StringBuffer("FROM User where userName = :userName");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", "test2");
			userList = findByHQL(hql.toString(),map);
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return userList;
	}
	
	
	public List<User> getUsersWithCriteriaBasics() {
		List<User> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			userList = findByCriteria(criterion);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return userList;
	}
	 
	
	public List<User> getUsersWithCriteria(){
		List<User> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			Criterion criterion1 = Restrictions.like("userName", "test");
			LogicalExpression orExp = Restrictions.or(criterion, criterion1);
			
			userList = findByCriteria(orExp);
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return userList;
	}
	
	public List<User> getUsersWithCriteriaProjection(){
		List<User> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.rowCount());
			List rowCount = (List) findByCriteria(projectionList, criterion);
			System.out.println("rowCount ->"+rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<Object[]> getUsersWithCriteriaProjectionSingleProp(){
		List<Object[]> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("keyword"));
			List<String> pwd = (List<String>)findByCriteria(projectionList,  criterion);
			System.out.println(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<Object[]> getUsersWithCriteriaProjectionProps(){
		List<Object[]> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("userName"));
			projectionList.add(Projections.property("keyword"));
			userList = (List<Object[]>)findByCriteria(projectionList,  criterion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<Object[]> getUsersWithCriteriaQueryByExampleSingleColumn(){
		List<Object[]> userList = new ArrayList<>();
		try {
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("userName"));
			User user = new User();
			user.setKeyword("test");
			List<String> userName = (List<String>)findByCriteria(user,  projectionList);
			System.out.println(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<Object[]> getUsersWithCriteriaQueryByExample(){
		List<Object[]> userList = new ArrayList<>();
		try {
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("userName"));
			projectionList.add(Projections.property("keyword"));
			User user = new User();
			user.setKeyword("test");
			userList = (List<Object[]>)findByCriteria(user,  projectionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public List<User> getUsersWithCriteriaCacheable(){
		List<User> userList = new ArrayList<>();
		try {
			Criterion criterion = Restrictions.eq("userName", "test1");
			userList = findByCriteriaCacheable(criterion);
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return userList;
	}
	
}
