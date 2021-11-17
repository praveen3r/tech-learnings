package com.wipro.campaign.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler
{

   @ExceptionHandler(BadCredentialsException.class)
   public ResponseEntity<String> badException()
   {
      final ResponseEntity<String> resp = new ResponseEntity<>("Invalid Userid/Password",
         HttpStatus.BAD_REQUEST);
      return resp;
   }
}
