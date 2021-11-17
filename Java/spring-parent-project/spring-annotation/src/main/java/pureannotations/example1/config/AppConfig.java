package pureannotations.example1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import pureannotations.example1.drivers.DataBaseDriver;
import pureannotations.example1.drivers.MySqlDriver;
import pureannotations.example1.drivers.OracleDriver;

@Configuration
@ComponentScan("pureannotations/example1")
@PropertySource("classpath:oracledatabase.properties")
public class AppConfig {

	@Autowired
    Environment environment;
	
	@Bean
	DataBaseDriver oracleDriver() {
		OracleDriver oracleDriver = new OracleDriver();
		oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;

	}

	@Bean
	DataBaseDriver mysqlDriver() {
		return new MySqlDriver();
	}
}
