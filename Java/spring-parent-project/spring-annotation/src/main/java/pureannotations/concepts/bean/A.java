package pureannotations.concepts.bean;

import org.springframework.context.annotation.Bean;


public class A {
    @Bean
    public void display() {
        System.out.println("@Bean Demo");
    }
}
