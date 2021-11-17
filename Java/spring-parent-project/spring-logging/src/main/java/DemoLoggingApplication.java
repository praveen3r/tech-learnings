import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoLoggingApplication {

	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoLoggingApplication.class);
		sp.run(args);
		Logger log = LoggerFactory.getLogger(DemoLoggingApplication.class);
		log.debug("debug statement");
		log.debug("debug statement1");
	}
}
