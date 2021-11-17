package com.demo.repository;

import java.io.Serializable;
import java.util.List;


public interface BaseRepository<T, ID extends Serializable>{

	//T findById(ID id, boolean lock) throws Exception;

	List<T> findAll() throws Exception;

	T makePersistent(T entity) throws Exception;

	void makeTransient(T entity) throws Exception;

	int makeTransient(List<T> entityList) throws Exception;

	List<T> makePersistent(List<T> entityList) throws Exception;
}
