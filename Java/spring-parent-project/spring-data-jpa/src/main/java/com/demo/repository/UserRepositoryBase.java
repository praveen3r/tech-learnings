package com.demo.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface UserRepositoryBase <T, ID extends Serializable> extends Repository<T, ID> {

	  Optional<T> findById(ID id);

	  <S extends T> S save(S entity);
}
