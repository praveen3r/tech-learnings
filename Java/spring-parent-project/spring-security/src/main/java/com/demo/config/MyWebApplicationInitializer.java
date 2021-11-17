package com.demo.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MyWebApplicationInitializer extends SpringBootServletInitializer {

    /*@Override
    public void onStartup(ServletContext container) {
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/demo/*");
    }
*/

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application
                .sources(DefaultConfiguration.class);
    }
}