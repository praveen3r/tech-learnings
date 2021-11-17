package com.wipro.campaign.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.campaign.entity.User;
import com.wipro.campaign.repository.UserRepository;

@Service
public class UserService
{

   @Autowired
   UserRepository userRepository;

   public List<User> getAllPersons()
   {
      List<User> userList = userRepository.findAll();
      return userList;
   }
   
   public List<User> getAllUsers()
   {
      List<User> userFinalList  = new ArrayList<>();
      List<User> userList = userRepository.findAll();
      if(Optional.ofNullable(userList).isPresent())
         userFinalList = userList.stream().filter(user -> !user.getRole().equals("admin")).collect(Collectors.toList());
      return userFinalList;
   }
   
   public Integer getNoUsers()
   {
      Integer noUser = 0;
      noUser = (int) userRepository.findAll().stream().filter(user->user.getRole().equalsIgnoreCase("user")).count();
      return noUser;
   }

   public void saveUser(final User user)
   {
      userRepository.save(user);
   }

   public String authenticate(final String username, final String password)
   {
      String ret = null;
      final List<User> users = getAllPersons();
      final Optional<User> logUser = users.stream().filter(user ->
      {
         if (user.getEmailId().equalsIgnoreCase(username) && user.getPassword().equals(password))
         {
            return true;
         }
         return false;
      }).findFirst();
      if (logUser.isPresent())
      {
         ret = logUser.get().getRole();
      }
      return ret;
   }
}
