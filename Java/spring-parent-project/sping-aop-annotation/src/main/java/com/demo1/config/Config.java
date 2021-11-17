package com.demo1.config;

import com.demo1.repository.CustomerImpl;
import com.demo1.service.CustomerAddress;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

@ComponentScan("com.demo1")
//@ComponentScan(basePackages = {"com.demo1"},
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.demo1.service.*"))


@Configuration
@EnableAspectJAutoProxy
public class Config {


}
