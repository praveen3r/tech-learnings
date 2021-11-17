/*package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*")
public class DemoFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("coming to destroy DemoFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("coming to init DemoFilter");
	}

	@Override
	public void doFilter(ServletRequest request, 
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest)request;
		try {
			System.out.println(httpReq.getParameterMap());
			if(httpReq.getParameterMap().isEmpty())
				request.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                .forward(request, response);
			chain.doFilter(request, response);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp")
                               .forward(request, response);
		}

	}

}
*/