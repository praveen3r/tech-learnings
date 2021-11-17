package com.demo.repository;

import java.io.Serializable;
import java.util.List;


public interface BaseRepository<T, ID extends Serializable>{

	List<T> makePersistent(List<T> entityList) throws Exception;

}
