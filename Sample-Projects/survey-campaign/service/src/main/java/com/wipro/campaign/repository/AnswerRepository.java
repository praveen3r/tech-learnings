package com.wipro.campaign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wipro.campaign.entity.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long>
{

	   @Override
	   @Query("Select cm FROM Answer cm")
	   List<Answer> findAll();

}
