package com.wipro.campaign.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wipro.campaign.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>
{

   @Override
   List<User> findAll();
}
