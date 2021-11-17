package ioc.lifecycle.bean;

public class Employee {
    public Employee() {
        System.out.println("Employee no-args constructor called");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
