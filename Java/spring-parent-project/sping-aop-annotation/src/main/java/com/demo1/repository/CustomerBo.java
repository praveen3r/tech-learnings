package com.demo1.repository;

public interface CustomerBo {

    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);

    void updateCustomer(String name);

    void removeCustomer(String name);
}