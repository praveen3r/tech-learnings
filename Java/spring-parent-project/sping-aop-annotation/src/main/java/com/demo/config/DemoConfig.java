package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan("com.demo")
//TODO : Active the AOP
//@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
@EnableAspectJAutoProxy
//@EnableSpringConfigured
//@EnableLoadTimeWeaving(aspectjWeaving=AspectJWeaving.ENABLED)
public class DemoConfig {
    /*@Bean(name = "car")
    public Car getCar() {
        return new Car();
    }*/
}
