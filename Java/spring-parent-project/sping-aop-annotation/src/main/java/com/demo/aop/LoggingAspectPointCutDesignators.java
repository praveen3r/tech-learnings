package com.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspectPointCutDesignators implements Ordered{
    //TODO : will it able to inherent aspect by  like extends LoggingAspectPointCut {

	@Override
	public int getOrder() {
		return 0;
	}
	
	@Before("any_Method_That_Start_With_Dr()")
	public void log(){
		System.out.println("logging from aspect class");
	}

    @Pointcut("execution(* *(..))")
    public void any_Method_That_Start_With_Dr() {
    }


	@Pointcut("within(com.demo.bean.Car.*)")
	public void all_Classes_All_Methods_Within_Package_Only(){
	}
//
//	@Pointcut("within(com.demo.bean.Car..*)")
//	public void all_Classes_All_Methods_Within_Package_And_SubPackage(){
//	}
//
//	@Before("args()")
//	public void any_MethodExecution_With_No_Argument(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(String)")
//	public void any_MethodExecution_With_String_Argument(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(String,int)")
//	public void any_MethodExecution_With_String_And_Int_Argument(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(String,*)")
//	public void any_MethodExecution_With_String_And_Any_Argument(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(*)")
//	public void any_MethodExecution_With_One_Args_And_Any_Type(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(..)")
//	public void any_MethodExecution_With_Any_Args_And_Any_Type(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("args(var1)")
//	public void any_MethodExecution_With_Dynamic_Variables(int var1){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("bean(car)")
//	public void all_Methods_With_Bean_Name_Car(int var1){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("bean(car*)")
//	public void all_Methods_With_Bean_Name_Starts_With_Car(int var1){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("execution( * (@org.springframework.stereotype.Component *).* (..))")
//	public void any_Class_Annotated_With_Component(){
//		System.out.println("logging from aspect class");
//	}
//
//	@Before("@target(org.springframework.stereotype.Component)")
//	public void any_Class_Annotated_With_Component(){
//		System.out.println("logging from aspect class");
//	}

}
