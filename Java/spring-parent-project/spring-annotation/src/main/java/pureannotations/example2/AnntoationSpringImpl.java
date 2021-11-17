package pureannotations.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnntoationSpringImpl {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("pureannotations.example2");
//        context.scan("com");

        context.refresh();

        Employee employee = (Employee) context.getBean("employee");

        employee.setEmpId("S1001");
        employee.setEmpName("Sudhir");
        employee.setSalary(67000);

        System.out.println("Employee ID:" + employee.getEmpId());
        System.out.println("Employee Name:" + employee.getEmpName());
        System.out.println("Employee Salary:" + employee.getSalary());
    }

}
