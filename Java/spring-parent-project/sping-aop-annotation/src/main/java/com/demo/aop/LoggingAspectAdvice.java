package com.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component

@Aspect
@Order(2)
public class LoggingAspectAdvice {

    //Scenario -1
//    @Before("execution(void com.demo.bean.Car.drive())")
//    public void logBefore() {
//        System.out.println("logging from aspect class");
//    }
//
//    @Before("execution(void com.demo.bean.Bike.display())")
//    public void logBeforeBike() {
//        System.out.println("logging from aspect class");
//    }


    //Scenario -2
//	@Before("execution(void com.demo.bean.Car.drive(..))")
//	public void logBefore() throws Exception{
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("execution(void com.demo.bean.Car.drive(..))")
//	public void logBefore(JoinPoint jp){
//		System.out.println("logging from aspect class");
//
//		System.out.println("jp.getStaticPart()->" +jp.getStaticPart());
//		System.out.println("jp.getKind()->" +jp.getKind());
//		Object args[] = jp.getArgs();
//		Integer speed = ((Integer)args[0]).intValue();
//		System.out.println("jp args->" +speed);
//		System.out.println("jp.getTarget()->" +jp.getTarget());
//	}
//
//	@AfterReturning("execution(String com.demo.bean.Car.driveFast())")
//	public void logAfterReturning() throws Exception{
//		System.out.println("logging from aspect class");
//	}
//
//	@AfterReturning(pointcut="execution(String com.demo.bean.Car.driveFast())",returning="ret")
//	public void logAfterReturning(String ret) throws Exception{
//		System.out.println(ret);
//		System.out.println("logging from aspect class");
//	}
//
//	@AfterThrowing(pointcut="execution(String com.demo.bean.Car.driveFast1())", throwing="ex")
//	public void logAfterThrowing(Exception ex) {
//		System.out.println("exception is "+ex);
//		System.out.println("logging from aspect class");
//	}
//
//	@After("execution(String com.demo.bean.Car.driveFast1())")
//	public void logAfter() {
//		System.out.println("logging from aspect class");
//	}
//
//	@Around("execution(String com.demo.bean.Car.driveFast2(..))")
//	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("logging before method execution");
//
//		//you can stop execution of method if needed
//		pjp.proceed();
//
//		System.out.println("logging after method execution");
//	}
//
//	@Around("execution(String com.demo.bean.Car.driveFast2(..))")
//	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("logging before method execution");
//
//		try {
//		pjp.proceed();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("logging after method execution");
//	}
//
//	@Around("execution(String com.demo.bean.Car.driveFast2(..))")
//	public void logAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("logging before method execution");
//
//		Object[] args = pjp.getArgs();
//
//		int speed = (Integer)args[0];
//
//		args[0] = 25;
//
//		System.out.println("speed in aspect is "+speed);
//
//		try {
//			pjp.proceed(args);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("logging after method execution");
//	}
//
//	@Around("execution(String com.demo.bean.Car.driveFast2(..))")
//	public String logAround(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("logging before method execution");
//		String returnVal = null;
//
//		try {
//			Object value = pjp.proceed();
//			returnVal = "aspect value";
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("logging after method execution");
//		return returnVal;
//	}

}
