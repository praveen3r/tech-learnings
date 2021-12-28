package com.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Application
{
   public static void main(final String[] args)
   {
      final SpringApplication springApplication = new SpringApplication(Application.class);
      springApplication.setBannerMode(Banner.Mode.OFF);
      springApplication.run(args);

   }
}