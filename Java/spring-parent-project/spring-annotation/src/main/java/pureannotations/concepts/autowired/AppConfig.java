package pureannotations.concepts.autowired;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages = {"pureannotations.concepts.autowired","pureannotations.concepts1.autowired"})
//@ComponentScan(basePackages = "pureannotations.concepts.autowired")
//@Import(AppConfig_01.class)
public class AppConfig {
    //TODO : Class CTest
    @Bean
    public CTest getC1() {
        return new CTest();
    }

    @Bean
    //@Bean(name = "C2")
    public CTest getC2() {
        return new CTest();
    }

    //External Class injection
    /*@Bean(name = "alphabet")
    public CTest alphabet() {
        return new CTest();
    }*/

    //External Class injection may be from different group or jar.
    @Bean(name = "number",initMethod = "init",destroyMethod = "cleanup")
    @Scope("singleton")
    public Number getNumber() {
        return new Number();
    }


}
