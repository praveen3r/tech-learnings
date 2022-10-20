/*
 * package com.demo.aspect;
 * 
 * import java.util.Arrays;
 * 
 * import org.aspectj.lang.JoinPoint; import
 * org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.AfterThrowing; import
 * org.aspectj.lang.annotation.Around; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.aspectj.lang.annotation.Pointcut; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.env.Environment; import
 * org.springframework.dao.DataAccessException; import
 * org.springframework.stereotype.Component;
 * 
 * import com.demo.util.Constants;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @Component
 * 
 * @Aspect
 * 
 * @Slf4j public class LoggingAspect {
 * 
 * @Autowired private Environment environment;
 * 
 * @Pointcut("within(com.cyc.repository..*) || within(com.cyc.service..*)")
 * public void loggingPoincut() { }
 * 
 * @AfterThrowing(pointcut = "loggingPoincut()", throwing = "e") public void
 * logAfterThrowing(JoinPoint joinPoint, Throwable e) {
 * if(Arrays.stream(environment.getActiveProfiles()).anyMatch(env ->
 * env.equalsIgnoreCase(Constants.SPRING_PROFILE_DEVELOPMENT)))
 * log.error("Exception in {}.{}() with cause = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), e.getCause(), e); else { if(e instanceof
 * DataAccessException) log.error("Exception in {}.{}() with cause = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), e.toString()); else { if(e.getCause() !=
 * null) log.error("Exception in {}.{}() with cause = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), e.getCause()); else
 * log.error("Exception in {}.{}() with cause = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), e.toString()); } } }
 * 
 * @Around("loggingPoincut()") public Object logAround(ProceedingJoinPoint
 * joinPoint) throws Throwable { if (log.isDebugEnabled()) {
 * log.debug("Method enter: {}.{}() with argument[s] = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())); }
 * try { Object result = joinPoint.proceed(); if (log.isDebugEnabled()) {
 * log.debug("Method exit: {}.{}() with result = {}",
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName(), result); } return result; } catch
 * (IllegalArgumentException e) { log.error("Illegal argument: {} in {}.{}()",
 * Arrays.toString(joinPoint.getArgs()),
 * joinPoint.getSignature().getDeclaringTypeName(),
 * joinPoint.getSignature().getName());
 * 
 * throw e; } } }
 */