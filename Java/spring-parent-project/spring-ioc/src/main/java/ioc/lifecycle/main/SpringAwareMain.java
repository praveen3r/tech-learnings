package ioc.lifecycle.main;

import ioc.lifecycle.service.MyAwareService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAwareMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springlifecycle-aware.xml");

		ctx.getBean("myAwareService", MyAwareService.class);
		
		ctx.close();
	}

}
