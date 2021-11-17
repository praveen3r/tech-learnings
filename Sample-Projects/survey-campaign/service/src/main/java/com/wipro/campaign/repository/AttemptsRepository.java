package com.wipro.campaign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wipro.campaign.entity.Attempts;

public interface AttemptsRepository extends CrudRepository<Attempts, Long>
{

	   @Override
	   @Query("Select cm FROM Attempts cm")
	   List<Attempts> findAll();
	   
	   @Query("Select cm FROM Attempts cm where EMAILID =:id")
	   List<Attempts> findByEmail(@Param("id") String id);

}
