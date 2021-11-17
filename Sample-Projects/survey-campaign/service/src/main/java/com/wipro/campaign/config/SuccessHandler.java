package com.wipro.campaign.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{

   @Override
   public void onAuthenticationSuccess(final HttpServletRequest request,
      final HttpServletResponse response, final Authentication authentication)
      throws ServletException, IOException
   {
      try
      {
         final ObjectMapper mapper = new ObjectMapper();
         final ObjectNode node = mapper.createObjectNode();
         String userAuthority = "";
         for (final GrantedAuthority authority : authentication.getAuthorities())
         {
            userAuthority = authority.getAuthority();
         }
         if (userAuthority.equalsIgnoreCase("admin"))
         {
            node.put("role", "admin");
         }
         else
         {
            node.put("role", "user");
         }
         final PrintWriter out = response.getWriter();
         out.print(node.toString());
         out.flush();
         out.close();
      }
      catch (final Exception e)
      {
         throw new ServletException("Unable to create the auth token", e);
      }
      clearAuthenticationAttributes(request);

   }
}
