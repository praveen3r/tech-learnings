package com.wipro.campaign.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.wipro.campaign.services.UserService;

@Component
public class ApiUserAuthenticationProvider implements AuthenticationProvider
{

   private static final Logger LOGGER = LoggerFactory
      .getLogger(ApiUserAuthenticationProvider.class);

   @Autowired
   UserService userService;

   @Override
   public Authentication authenticate(final Authentication authentication)
      throws AuthenticationException
   {
      LOGGER.info("Attempting to authenticate user [{}] from [{}]", authentication.getPrincipal(),
         authentication.getDetails());

      UsernamePasswordAuthenticationToken upt = null;
      final String username = authentication.getPrincipal().toString();
      final String password = authentication.getCredentials().toString();
      final String ret = userService.authenticate(username, password);
      if (Optional.ofNullable(ret).isPresent())
      {
         upt = new UsernamePasswordAuthenticationToken(username, null,
            AuthorityUtils.createAuthorityList(ret));
      }
      else
      {
         throw new BadCredentialsException("Invalid userid/password");
      }
      if (upt != null)
      {
         LOGGER.info("Successfully authentiated user [{}}", authentication.getPrincipal());
      }
      return upt;
   }

   @Override
   public boolean supports(final Class<?> authentication)
   {
      // TODO Auto-generated method stub
      return authentication.equals(UsernamePasswordAuthenticationToken.class);
   }

}
