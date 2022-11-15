package com.demo.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.demo.util.CommonUtil;
import com.demo.util.Profile;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect
{

   @Autowired
   private Environment environment;

   @Pointcut("within(com.demo.service..*)")
   public void loggingPoincut()
   {
   }

   /**
    * @param joinPoint
    * @param e
    */
   @AfterThrowing(pointcut = "loggingPoincut()", throwing = "e")
   public void logAfterThrowing(final JoinPoint joinPoint, final Throwable e)
   {
      final var profile = Profile.DEV;
      if (environment.getActiveProfiles().length == 0)
      {
         log.error("Exception in {}.{}() with cause = {}",
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
            e.getCause(), e);
      }
      else
      {
         if (Arrays.stream(environment.getActiveProfiles())
            .anyMatch(env -> CommonUtil.compareValues(env, profile.getProfile())))
         {
            log.error("Exception in {}.{}() with cause = {}",
               joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
               e.getCause(), e);
         }
         else
         {
            if (e instanceof PSQLException)
            {
               final var sqlEx = (PSQLException) e;
               final var sqlErrorCode = sqlEx.getSQLState();
               final var sqlMessage = sqlEx.getMessage();
               log.error("Exception in {}.{}() with errorcode = {} and errormsg = {}",
                  joinPoint.getSignature().getDeclaringTypeName(),
                  joinPoint.getSignature().getName(), sqlErrorCode, sqlMessage);
            }
            else if (e instanceof DataAccessException)
            {
               log.error("Exception in {}.{}() with cause = {}",
                  joinPoint.getSignature().getDeclaringTypeName(),
                  joinPoint.getSignature().getName(), e.toString());
            }
            else
            {
               if (CommonUtil.isNotEmpty(e.getCause()))
               {
                  log.error("Exception in {}.{}() with cause = {}",
                     joinPoint.getSignature().getDeclaringTypeName(),
                     joinPoint.getSignature().getName(), e.getCause());
               }
               else
               {
                  log.error("Exception in {}.{}() with cause = {}",
                     joinPoint.getSignature().getDeclaringTypeName(),
                     joinPoint.getSignature().getName(), e.toString());
               }
            }
         }
      }
   }

   /**
    * @param joinPoint
    * @return
    * @throws Throwable
    */
   @Around("loggingPoincut()")
   public Object logAround(final ProceedingJoinPoint joinPoint) throws Throwable
   {
      if (log.isDebugEnabled())
      {
         log.debug("Method enter: {}.{}() with argument[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
      }
      try
      {
         final var result = joinPoint.proceed();
         if (log.isDebugEnabled())
         {
            log.debug("Method exit: {}.{}() with result = {}",
               joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
               result);
         }
         return result;
      }
      catch (final IllegalArgumentException e)
      {
         log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
            joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

         throw e;
      }
   }
}
