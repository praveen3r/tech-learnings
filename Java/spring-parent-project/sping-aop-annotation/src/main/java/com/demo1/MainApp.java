package com.demo1;

import com.demo1.config.Config;
import com.demo1.repository.CustomerBo;
import com.demo1.repository.CustomerImpl;
import com.demo1.service.CustomerAddress;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {

    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);
//TODO:verify
//        System.out.println("Customer Name :" + ((CustomerImpl) appContext.getBean("customerImpl")).getName());
//        System.out.println("Customer Name :" + (appContext.getBean("customerImpl", CustomerImpl.class)).getName());
//        Exception in thread "main" java.lang.ClassCastException:
//              com.sun.proxy.$Proxy19 cannot be cast to com.demo1.repository.CustomerImpl

//        System.out.println("Customer City :" + appContext.getBean("customerAddress", CustomerAddress.class).getCity());
//TODO : working
//        CustomerImpl customerBo = (CustomerImpl) appContext.getBean("CustomerImpl");
//        CustomerBo customerBo = (CustomerImpl) appContext.getBean("CustomerImpl");
//        CustomerBo customerBo = (CustomerBo) appContext.getBean(CustomerImpl.class);
//        CustomerBo customerBo = (CustomerBo) appContext.getBean(CustomerImpl.class);

//Fist letter should in lowercase of the classname.

        //Example 1
//        CustomerBo customerBo = (CustomerImpl) appContext.getBean("customerImpl");
        //Exception in thread "main" java.lang.ClassCastException:
        // com.sun.proxy.$Proxy18 cannot be cast to com.demo1.repository.CustomerImpl

        //Example 2
//        CustomerBo customerBo = (CustomerBo) appContext.getBean("customerImpl");

        //Example 3 - excluded in component scan
//        CustomerBo customerBo1 = (CustomerBo) appContext.getBean("customerAddress");

//        customerBo.addCustomer();
        //Example 4
        CustomerBo customer = (CustomerBo) appContext.getBean("customerImpl");
//        customer.addCustomerReturnValue();
        //Example 5
//        customer.addCustomerThrowException();
        //Example 6
//        customer.addCustomerAround("Ronav");
        //Example 7
//        customerBo1.addCustomer();

        ((AnnotationConfigApplicationContext) appContext).close();
    }
}
