package com.demo1.service;

import com.demo1.repository.CustomerBo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddress implements CustomerBo {
    @Value("Bangalore")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
