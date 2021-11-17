package com.wipro.campaign.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.campaign.entity.Campaign;
import com.wipro.campaign.entity.Question;
import com.wipro.campaign.repository.CampaignRepository;
import com.wipro.campaign.repository.QuestionRepository;

@Service
public class CampaignService
{

   @Autowired
   CampaignRepository campaignRepository;

   @Autowired
   QuestionRepository questionRepository;

   public List<Campaign> getCampaigns()
   {
      return campaignRepository.findAll();
   }
   
   public Campaign getCampaign(Long id)
   {
      Campaign campaign=null;
      campaign = campaignRepository.findById(id).get();
      return campaign;
   }

   public void saveCampaign(final Campaign campaign)
   {
      final List<Question> questionList = new ArrayList<>();
      campaign.getQuestionList().forEach(question ->
      {
         question.setCampaign(campaign);
         questionList.add(question);
      });
      campaign.setQuestionList(questionList);

      campaignRepository.save(campaign);
   }

   public void deleteCampaign(final Long id)
   {
      campaignRepository.deleteCampaign(id);
   }

   public void deleteQuestion(final Long id)
   {
      questionRepository.deleteQuestion(id);
   }

}
