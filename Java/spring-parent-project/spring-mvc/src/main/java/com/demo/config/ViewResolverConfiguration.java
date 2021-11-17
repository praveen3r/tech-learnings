package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class ViewResolverConfiguration extends WebApplicationObjectSupport{

	@Bean
    public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	/*@Bean
	public ViewResolver resourceBundleViewResolver() {
	    ResourceBundleViewResolver bean = new ResourceBundleViewResolver();
	    bean.setBasename("views");
	    return bean;
	}
	
	@Bean
	public ViewResolver resourceBundleViewResolver() {
		XmlViewResolver bean = new XmlViewResolver();
		Resource resource = getApplicationContext().getResource("/WEB-INF/config/views.xml");;
	    bean.setLocation(resource);
	    return bean;
	}*/
	
	
}
