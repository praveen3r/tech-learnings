package com.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.demo.filter.AuthenticationFilter;
import com.demo.security.handler.AuthFailureHandler;
import com.demo.security.handler.AuthLogOutHandler;
import com.demo.security.handler.AuthSuccessHandler;
import com.demo.security.provider.AuthProvider;
import com.demo.security.token.TokenManager;
import com.demo.security.util.UnauthorizedEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class WebSecurityConfig {
	
	@Autowired
    private AuthProvider authProvider;
	
	@Autowired
    private AuthSuccessHandler authSuccessHandler;
	
	@Autowired
    private AuthFailureHandler authFailureHandler;
	
	@Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;
	
	@Autowired
    private AuthLogOutHandler authLogOutHandler;
	
	@Autowired
	TokenManager tokenManager;
	
	@Value("${token.expiry.key}")
	private String expiryKey;

	@Value("${token.expiry.time}")
	private Long expiryTime;
	
	@Value("${cors.allow-methods}")
	private String[] allowedMethods;
	
	@Value("${cors.domain}")
	private String domain;
	
	@Value("${cors.allow-headers}")
	private String[] allowedHeaders;
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	    		.authenticationProvider(authProvider)
	      .build();
	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> {
			return corsConfiguration();
        }).and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterBefore(new AuthenticationFilter(tokenManager, expiryKey, expiryTime), LogoutFilter.class)
		
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/v1/sec/key/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginProcessingUrl("/demo/authentication").permitAll()
		.usernameParameter("secure_username").passwordParameter("secure_keyword")
		.successHandler(authSuccessHandler)
		.failureHandler(authFailureHandler)
		.and().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)
		.and().logout().logoutUrl("/demo/authentication/logout").logoutSuccessHandler(authLogOutHandler);
		
		return http.build();
	}
	
	
	@Bean
	CorsConfiguration corsConfiguration() {
		var configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(domain));
		configuration.setAllowedMethods(Arrays.asList(allowedMethods));
		configuration.setAllowedHeaders(List.of(allowedHeaders));
		return configuration;
	}
	 
	
}
