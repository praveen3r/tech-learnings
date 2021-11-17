package com.wipro.campaign.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.campaign.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>
{

   @Modifying
   @Transactional
   @Query("DELETE FROM Question where questionId = :id")
   void deleteQuestion(@Param("id") Long id);
}
