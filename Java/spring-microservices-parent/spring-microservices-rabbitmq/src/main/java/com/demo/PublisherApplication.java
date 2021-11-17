/*
 * package com.demo;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication; import
 * org.springframework.cloud.stream.annotation.EnableBinding; import
 * org.springframework.integration.support.MessageBuilder;
 * 
 * import com.demo.model.User; import com.demo.source.DemoSource;
 * 
 * @SpringBootApplication
 * 
 * @EnableBinding(DemoSource.class) public class PublisherApplication implements
 * CommandLineRunner{
 * 
 * @Autowired DemoSource demoSource;
 * 
 * public static void main(String[] args) { SpringApplication sp = new
 * SpringApplication(PublisherApplication.class); sp.run(args);
 * 
 * }
 * 
 * @Override public void run(String... args) throws Exception {
 * System.out.println("Sending message..."); User user = new User();
 * user.setUserId("testId"); user.setUserName("testName");
 * demoSource.userChannel().send(MessageBuilder.withPayload(user).build());
 * 
 * }
 * 
 * }
 */