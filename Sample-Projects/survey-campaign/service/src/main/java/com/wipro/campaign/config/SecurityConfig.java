package com.wipro.campaign.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.wipro.campaign.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
   private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

   @Autowired
   ApiUserAuthenticationProvider authenticationProvider;

   @Autowired
   SuccessHandler successHandler;

   @Autowired
   CustomAuthenticationFailureHandler authenticationFailureHandler;

   @Autowired
   public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception
   {
      try
      {
         auth.authenticationProvider(authenticationProvider);
      }
      catch (final Exception e)
      {
         LOGGER.error("Exception in : ", e);
         throw new Exception(e.getMessage());
      }
   }

   @Override
   protected void configure(final HttpSecurity http) throws Exception
   {
      http.cors().and().addFilterBefore(new CorsFilter(), LogoutFilter.class).headers()
         .frameOptions().sameOrigin().and().formLogin().loginProcessingUrl("/app/authentication")
         .successHandler(successHandler).failureHandler(authenticationFailureHandler)
         .usernameParameter("j_username").passwordParameter("j_password").permitAll().and()
         .exceptionHandling().and().logout().logoutUrl("/app/logout")
         .logoutSuccessHandler((request, response, authentication) ->
         {
            response.setStatus(HttpServletResponse.SC_OK);
         }).deleteCookies("JSESSIONID").permitAll().and().csrf().disable().authorizeRequests()
         .antMatchers("/h2-console/**", "/register/**").permitAll().anyRequest().permitAll();
   }

   @Bean
   CorsConfigurationSource corsConfigurationSource()
   {
      final CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(Arrays.asList("*"));
      configuration
         .setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT", "PATCH", "DELETE"));
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
   }
}
