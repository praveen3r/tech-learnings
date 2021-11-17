package pureannotations.concepts.basics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "pureannotations.concepts.basics")
public class AppConfig {
    //configure any beans
    @Bean
    public HelloBean getHelloBean() {
        HelloBean helloBean = new HelloBean();
        return helloBean;
    }

    @Bean(name = "helloByName1")
    public HelloBean getHelloBeanByName1() {
        HelloBean helloBean = new HelloBean();
        return helloBean;
    }

    @Bean(name = "helloByName2")
    public HelloBean getHelloBeanByName2() {
        HelloBean helloBean = new HelloBean();
        return helloBean;
    }
}
