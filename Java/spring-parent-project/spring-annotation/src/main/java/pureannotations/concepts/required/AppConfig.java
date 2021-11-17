package pureannotations.concepts.required;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//TODO Scan for multiple locations.

@ComponentScan(basePackages = {"pureannotations.concepts.required", "pureannotations.concepts.required.test"})
public class AppConfig {


}
