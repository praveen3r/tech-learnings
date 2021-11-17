package pureannotations.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureDemo {
    @Bean(name = "employee")
    public Employee getEmployeeBean() {
        System.out.println("===Spring Container Created the Employee Bean and Stored");
        return new Employee();
    }
}