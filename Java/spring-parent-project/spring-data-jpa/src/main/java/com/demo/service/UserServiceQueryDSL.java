/*package com.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepositoryQueryDSL;
import com.querydsl.core.types.Predicate;

@Service
public class UserServiceQueryDSL {
	
	@Autowired 
	EntityManager em;

	@Autowired
	UserRepositoryQueryDSL userRepository;
	
	public void getData(){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.where(builder.equal(root.get("username"), "testprav"));
		em.createQuery(query.select(root)).getResultList();
	}
	
	

}
*/