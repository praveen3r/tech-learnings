package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.custom.security.CustomAuthProvider;
import com.demo.handler.CustomAuthFailureHandler;
import com.demo.handler.CustomAuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class CustomRestAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthProvider authProvider;
	
	@Autowired
    private CustomAuthSuccessHandler customAuthSuccessHandler;
	
	@Autowired
    private CustomAuthFailureHandler customAuthFailureHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login")
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
	*/	
		
		http.csrf().disable()
		//.requiresChannel()
		//.antMatchers("/*").requiresSecure().and()
		//.anyRequest().requiresSecure().and()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/authentication")
		.usernameParameter("secure_username").passwordParameter("secure_keyword")
		.successHandler(customAuthSuccessHandler)
		.failureHandler(customAuthFailureHandler)
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
		
	}
}
