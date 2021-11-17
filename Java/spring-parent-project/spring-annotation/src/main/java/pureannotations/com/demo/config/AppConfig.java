package pureannotations.com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig1.class)
public class AppConfig {

}
