package com.demo.repository;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import com.demo.entity.User;

public interface UserRepository extends JpaRepository<User, BigInteger> {
	
	List<User> findByUserNameAndPwd(String userName, String pwd);

	// Enables the distinct flag for the query

	List<User> findDistinctUserNameByPwd(String pwd);
	List<User> findDistinctUserNameByUserNameOrPwd(String userName, String pwd);

	// Enabling ignoring case for an individual property
	List<User> findByUserNameIgnoreCase(String userName);

	// Enabling ignoring case for all suitable properties
	List<User> findByUserNameAndPwdAllIgnoreCase(String userName, String pwd);

	// Enabling static ORDER BY for a query
	List<User> findByUserNameOrderByPwdAsc(String userName);
	List<User> findByUserNameOrderByPwdDesc(String userName);
	
	List<User> findFirst10ByUserName(String userName);
	List<User> findTop10ByUserName(String userName);
	
	List<User> findByUserNameLike(String userName);
	List<User> findByUserNameNotLike(String userName);
	List<User> findByUserNameNot(String userName);
	List<User> findByUserNameIs(String userName);
	List<User> findByUserNameEquals(String userName);
	List<User> findByUserNameIsNull();
	List<User> findByUserNameIsNotNull();
	List<User> findByIdBetween(BigInteger fromId, BigInteger toId);
	List<User> findByIdGreaterThanEqual(BigInteger id);
	List<User> findByIdLessThan(BigInteger id);
	List<User> findByIdLessThanEqual(BigInteger id);
	List<User> findByIdIn(Collection<BigInteger> ids);
	List<User> findByIdNotIn(Collection<BigInteger> ids);
	List<User> findByUserNameStartingWith(String userName);
	List<User> findByUserNameEndingWith(String userName);
	List<User> findByIdContaining(BigInteger fromId, BigInteger toId);
	
	@Async
	Future<User> findByUserName(String userName);
	
	@Async
	CompletableFuture<User> findOneByUserName(String userName); 
	
	@Async
	ListenableFuture<User> findOneByPwd(String pwd);  
	
	//Named Query
	List<User> findByUserNameNamedQuery(String userName);
	
	@Query("select u from User u where u.userName = ?1")
	List<User> findByUserNameQuery(String userName);
	
	@Query("select u from User u where u.userName like %?1")
	List<User> findByUserNameQueryLike(String userName);
	
	@Query("select u from User u where u.userName like ?1%")
	  List<User> findByAndSort(String userName, Sort sort);
	
	@Query("select u from User u where u.userName = :userName or u.pwd = :pwd")
	  User findByUserNameOrPwdParam(@Param("pwd") String pwd, @Param("userName") String userName);
	
	@Query(value = "SELECT * FROM USER_DATA WHERE USERNAME = ?1", nativeQuery = true)
	List<User> findByUserNameNativeQuery(String userName);
	
	@Query("select u from #{#entityName} u where u.userName = ?1")
	List<User> findByUserNameSpEL(String userName);
	
	@Modifying
	@Query("update User u set u.userName = ?1")
	int setUserName(String userName);
	
	@Modifying
	@Transactional
	@Query("delete from User u where u.userName = ?1")
	void  deleteUserName(String userName);
	
	void deleteByUserName(String userName);
	
	@QueryHints(value = { @QueryHint(name = "org.hibernate.comment", value = "value")})
	@Query("select u from User u where u.userName = ?1")
	List<User> findByUserNameQueryHints(String userName);
	
	/*@EntityGraph(type = EntityGraphType.LOAD)
	@Query("select u from User u where u.userName = ?1")
	List<User> findByUserNameEntityGraph(String userName);*/
	
}
