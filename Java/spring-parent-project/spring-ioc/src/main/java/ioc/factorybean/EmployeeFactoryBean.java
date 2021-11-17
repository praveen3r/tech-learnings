package ioc.factorybean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class EmployeeFactoryBean extends AbstractFactoryBean<Object> {
    private String designation;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    //This method will be called by container to create new instances
    protected Object createInstance() throws Exception {
        Employee employee = new Employee();
        employee.setId(-1);
        employee.setFirstName("dummy");
        employee.setLastName("dummy");
        //Set designation here
        employee.setDesignation(designation);
        return employee;
    }

    //This method is required for autowiring to work correctly
    public Class<Employee> getObjectType() {
        return Employee.class;
    }
}
