package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.demo.custom.security.JwtAuthProvider;
import com.demo.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtAuthFilterSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private JwtAuthProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/authentication").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/authentication")
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
		
	}
	
	
	private JwtAuthenticationFilter authenticationFilter() throws Exception {
		JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/authentication", "POST"));
		filter.setAuthenticationManager(authenticationManagerBean());
	    return filter;
	}
}
