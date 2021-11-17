package com.wipro.campaign.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.campaign.entity.User;
import com.wipro.campaign.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController
{
   @Autowired
   UserService userService;

   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public ResponseEntity<String> saveUser(@RequestBody final User user)
   {
      ResponseEntity<String> response = null;
      try
      {
         userService.saveUser(user);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
    	  log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }
   
   @RequestMapping(value = "/activeUser", method = RequestMethod.GET)
   public ResponseEntity<Integer> activeUser()
   {
      ResponseEntity<Integer> response = null;
      try
      {
         Integer noUser = userService.getNoUsers();
         response = new ResponseEntity<>(noUser,HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
      }
      return response;
   }
   
   @RequestMapping(value = "/users", method = RequestMethod.GET)
   public List<User> getUsersList()
   {
      return userService.getAllUsers();
   }
   
}
