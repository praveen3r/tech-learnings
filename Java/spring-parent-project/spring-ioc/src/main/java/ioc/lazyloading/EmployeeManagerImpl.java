package ioc.lazyloading;

import javax.annotation.PostConstruct;

public class EmployeeManagerImpl implements EmployeeManager {

    public EmployeeManagerImpl() {
    }

    public Employee create() {
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Lokesh");
        return emp;
    }

    @PostConstruct
    public void onInit() {
        System.out.println("EmployeeManagerImpl Bean is Created !!");
    }
}