/*package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.custom.security.CustomAuthProvider;

@Configuration
@EnableWebSecurity
public class CustomAuthSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest().authenticated().and()
		.formLogin().loginPage("/login").permitAll()
		.usernameParameter("custom_username").passwordParameter("custom_password")
		.loginProcessingUrl("/loginProcess").defaultSuccessUrl("/home1", true).and().logout()
		.logoutUrl("/perform_logout").invalidateHttpSession(true).deleteCookies("JSESSIONID");
		
		
		http
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin();
		
		http
		.authorizeRequests().antMatchers("/loginProcess").permitAll()
		.anyRequest().authenticated().and()
		.formLogin()
		.loginPage("/login").permitAll()
		.usernameParameter("custom_username").passwordParameter("custom_password")
		.loginProcessingUrl("/loginProcess").defaultSuccessUrl("/home1", true);
	}
}
*/