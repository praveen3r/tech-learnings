/*package com.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicAuthSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
      .withUser("test").password("test").roles("ADMIN")
      .and()
      .withUser("test1").password("test1").roles("ADMIN");
    }
     
	@Override
    protected void configure(HttpSecurity http) throws Exception {  
        
		http.authorizeRequests().anyRequest().permitAll()
	      .and()
	      .httpBasic();
		 
		http.authorizeRequests().anyRequest().fullyAuthenticated()
	      .and()
	      .httpBasic();
		
		http.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
	      .and()
	      .httpBasic();
		
    } 
}
*/