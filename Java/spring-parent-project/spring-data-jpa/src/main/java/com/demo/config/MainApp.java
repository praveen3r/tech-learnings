package com.demo.config;

import java.util.Arrays;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.demo.service.UserService;

@SpringBootApplication
public class MainApp implements CommandLineRunner{

	@Autowired
    private ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoConfig.class);
		sp.run(args);
		 /*AnnotationConfigApplicationContext context =
	              new AnnotationConfigApplicationContext(DemoConfig.class);*/
		

	}
	
	@Override
    public void run(String... args) throws Exception {
		 UserService userService = context.getBean(UserService.class);
		 userService.getDataWithAsync();
	      EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
	      emf.close();
       /* String[] beans = context.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {
            System.out.println(bean);
        }*/
	}


}
