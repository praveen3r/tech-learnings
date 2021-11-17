package pureannotations.example1;

import pureannotations.example1.config.AppConfig;
import pureannotations.example1.drivers.DataBaseDriver;
import pureannotations.example1.service.UserService;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		DataBaseDriver oracle = appContext.getBean("oracleDriver", DataBaseDriver.class);
		DataBaseDriver mysql = appContext.getBean("mysqlDriver", DataBaseDriver.class);
		
        System.out.println("Oracle driver info:");
        System.out.println(oracle.getInfo());
        
        System.out.println("MySQL driver info:");
        System.out.println(mysql.getInfo());

        System.out.println("UserService Information");
		UserService userService = appContext.getBean(UserService.class);
		System.out.println(userService.getDriverInfo());

		appContext.close();
	}
}
