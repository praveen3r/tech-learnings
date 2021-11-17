/*package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.custom.security.CustomRestDetailsAuthProvider;
import com.demo.custom.security.CustomWebAuthenticationDetailsSource;

@Configuration
@EnableWebSecurity
public class CustomRestAuthDetailsSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomRestDetailsAuthProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.authenticationDetailsSource(new CustomWebAuthenticationDetailsSource())
		.loginProcessingUrl("/authentication")
		.usernameParameter("secure_username").passwordParameter("secure_keyword")
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
		
	}
}
*/