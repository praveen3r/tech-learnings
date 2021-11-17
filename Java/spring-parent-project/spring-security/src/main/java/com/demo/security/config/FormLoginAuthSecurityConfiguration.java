/*package com.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
public class FormLoginAuthSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
      .withUser("test").password("test").roles("ADMIN");
    }
     
	@Override
    protected void configure(HttpSecurity http) throws Exception {  
             
		//With Spring default login form
		http.csrf().disable().authorizeRequests().anyRequest().authenticated()
	      .and()
	      .formLogin();
		
		//With Spring custom login form
		http.csrf().disable()
		  .authorizeRequests()
		  .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login").permitAll()
          .loginProcessingUrl("/home");
		
		//With Spring custom login form and custom params
		http.csrf().disable()
		  .authorizeRequests()
		  .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login").permitAll().usernameParameter("custom_username").passwordParameter("custom_password")
          .loginProcessingUrl("/home"); 
		
		//With Spring custom login form and custom params
		http.csrf().disable()
		  .authorizeRequests()
		  .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login").permitAll().usernameParameter("custom_username").passwordParameter("custom_password")
          .loginProcessingUrl("/loginProcess")
          .defaultSuccessUrl("/home1", true); 
		
		//With Spring custom login form and custom params with permit all
		http.csrf().disable()
		  .authorizeRequests().antMatchers("/loginProcess").permitAll()
		  .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login").permitAll().usernameParameter("custom_username").passwordParameter("custom_password")
          .loginProcessingUrl("/home")
          .defaultSuccessUrl("/home1", true); 
	      
		//Logout
		http.csrf().disable()
		  .authorizeRequests()
		  .anyRequest().authenticated()
	      .and()
	      .formLogin()
	      .loginPage("/login").permitAll().usernameParameter("custom_username").passwordParameter("custom_password")
          .loginProcessingUrl("/loginProcess")
          .defaultSuccessUrl("/home1", true)
          .and()
          .logout()
		  .logoutUrl("/perform_logout")
		  .invalidateHttpSession(true)
		  .deleteCookies("JSESSIONID"); 
		
		
    } 
}
*/