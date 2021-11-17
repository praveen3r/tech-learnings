package com.demo;

import java.util.List;

import org.activiti.engine.task.Task;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.service.MyService;
import com.demo.service.MyService1;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	MyService myService;
	
	@Autowired
	MyService1 myService1;

	public static void main(String[] args) {
		try {
			SpringApplication.run(DemoApplication.class, args);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * myService.startProcess(); //List<Task> tasks = myService.getTasks("kermit");
		 * List<Task> tasks = myService.getTasks(); for (Task task : tasks) {
		 * System.out.println(task.getId() +" "+ task.getName()); }
		 */
		myService1.createDemoUsers();
		myService1.startProcess("jbarrez");
		List<Task> tasks = myService1.getTasks("1");
		for (Task task : tasks) {
            System.out.println(task.getId() +" "+ task.getName());
        }
	}

	/*@Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Number of process definitions : "
                	+ repositoryService.createProcessDefinitionQuery().count());
                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
                runtimeService.startProcessInstanceByKey("oneTaskProcess");
                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
            }
        };

    }
	public CommandLineRunner init(MyService myService) {
		return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
            	myService.startProcess();
            	//List<Task> tasks = myService.getTasks("kermit");
            	List<Task> tasks = myService.getTasks();
                for (Task task : tasks) {
                    System.out.println(task.getId() +" "+ task.getName());
                }
            }
		};
	}*/
}
