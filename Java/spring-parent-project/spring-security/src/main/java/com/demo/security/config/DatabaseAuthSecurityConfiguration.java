/*package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class DatabaseAuthSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	CustomUserDetailsService userDetailsService;
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService);
    } 
     
	@Override
    protected void configure(HttpSecurity http) throws Exception {  
                 
		http.authorizeRequests()
		.anyRequest().authenticated()
	      .and()
	      .formLogin();
		 
    } 

}
*/