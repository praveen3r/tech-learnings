package com.demo1.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerImpl implements CustomerBo {

    @Value("John")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCustomer() {
        System.out.println("addCustomer() is running ");
    }

    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running ");
        return "abc";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running ");
        throw new Exception("Generic Error");
    }

    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args : " + name);
    }

    public void updateCustomer(String name) {
        System.out.println("updateCustomer() is running ");
    }

    public void removeCustomer(String name) {
        System.out.println("removeCustomer() is running ");
    }


}
