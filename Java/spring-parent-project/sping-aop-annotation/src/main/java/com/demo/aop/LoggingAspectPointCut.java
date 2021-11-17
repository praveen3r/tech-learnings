package com.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(1)
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class LoggingAspectPointCut {

    //missing execution()
    @Before("any_Method_That_Start_With_Dr()")
    public void log() {
        System.out.println("logging from aspect class through @Pointcut");
    }

    @Pointcut("execution(void com.demo.bean.Car.dr*(..))")
    public void any_Method_That_Start_With_Dr() {
    }

//
//    @Pointcut("execution(String *(..))")
//    public void any_Method_That_Returns_String() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.dr*(..))")
//    public void any_Method_That_Returns_With_Any_Type() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.*(..))")
//    public void all_Method_Within_That_Class() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.dr*(int))")
//    public void all_Method_With_Params_Int() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.dr*(int,int))")
//    public void all_Method_With_Params_Int_And_Int() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.dr*(*))")
//    public void all_Method_With_One_Params_Any_Type() {
//    }
//
//    @Pointcut("execution(* com.demo.bean.Car.dr*(*,int))")
//    public void all_Method_With_One_Params_Any_Type_And_Int() {
//    }
//
//    @Pointcut("execution(void com.demo.bean.Car.dr*(int,..))")
//    public void all_Method_With_First_Int_And_Any_Type_And_Number() {
//    }

}
