package com.wipro.campaign.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.campaign.entity.Campaign;

public interface CampaignRepository extends CrudRepository<Campaign, Long>
{

   @Override
   @Query("Select cm FROM Campaign cm")
   List<Campaign> findAll();
   
   @Override
   @Query("Select cm FROM Campaign cm where campaignId = :id")
   Optional<Campaign> findById(@Param("id") Long id);

   @Modifying
   @Transactional
   @Query("DELETE FROM Campaign where campaignId = :id")
   void deleteCampaign(@Param("id") Long id);
}
