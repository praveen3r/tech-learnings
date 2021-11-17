package com.wipro.campaign.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter
{

   @Override
   protected void doFilterInternal(final HttpServletRequest request,
      final HttpServletResponse response, final FilterChain filterChain)
      throws ServletException, IOException
   {

      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Credentials", "true");
      response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers",
         "Origin, Content-Type, Accept, Authorization, X-Auth-Token, ldbid, user-id, uuid");

      if (request.getMethod().equalsIgnoreCase("OPTIONS"))
      {
         response.setStatus(HttpServletResponse.SC_OK);
      }
      else
      {
         filterChain.doFilter(request, response);
      }

   }
}