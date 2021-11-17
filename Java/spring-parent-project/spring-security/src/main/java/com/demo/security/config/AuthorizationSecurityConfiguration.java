/*package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.custom.security.CustomRoleProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class AuthorizationSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomRoleProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		//.antMatchers("/test/rest1").hasAuthority("ROLE_USER")
		//.antMatchers("/test/rest1").access("hasRole('ROLE_USER')")
		//.antMatchers("/test/rest1").access("hasRole('ROLE_USER') or hasRole('ROLE_USER1')")
		//.antMatchers("/test/rest1").access("hasAnyRole('ROLE_USER','ROLE_USER1')")
		//.antMatchers("/test/rest1").access("principal == '122'")
		//.antMatchers("/test/rest1").access("authentication.principal == '1' ")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/authentication")
		.usernameParameter("secure_username").passwordParameter("secure_keyword")
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
		
	}
}
*/