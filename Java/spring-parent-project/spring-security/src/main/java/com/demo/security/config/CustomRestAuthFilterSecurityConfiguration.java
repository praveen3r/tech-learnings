/*package com.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.demo.custom.security.CustomRestAuthProvider;
import com.demo.filter.CustomAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomRestAuthFilterSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomRestAuthProvider authProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/authentication")
		.usernameParameter("secure_username").passwordParameter("secure_keyword")
		.and().exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint());
		
	}
	
	
	private CustomAuthenticationFilter authenticationFilter() throws Exception {
		CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
		filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/authentication", "POST"));
		filter.setUsernameParameter("secure_username");
		filter.setPasswordParameter("secure_keyword");
		filter.setAuthenticationManager(authenticationManagerBean());
	    return filter;
	}
}
*/