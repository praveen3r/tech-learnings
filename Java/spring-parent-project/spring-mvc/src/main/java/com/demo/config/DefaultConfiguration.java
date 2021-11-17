package com.demo.config;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.demo.interceptor.CustomInterceptor;
import com.demo.interceptor.CustomLocaleInterceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@Configuration 
//@Import({HandlerMappingConfiguration.class, ViewResolverConfiguration.class})
@Import({ViewResolverConfiguration.class})
@EnableWebMvc //equivalent to mvc:annotation-driven
@ComponentScan(basePackages="com.demo") //<context:component-scan base-package="com.demo"/>
public class DefaultConfiguration extends WebMvcConfigurerAdapter{
	
	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new CustomInterceptor());
	    registry.addInterceptor(new CustomInterceptor1()).addPathPatterns("/locale/home");
	    //registry.addInterceptor(localeChangeInterceptor());
	    //registry.addInterceptor(new CustomLocaleInterceptor());
	}*/
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
	}
	
	@Bean
    public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("i18/ApplicationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new CustomInterceptor());
	    //registry.addInterceptor(new CustomInterceptor1()).addPathPatterns("/locale/home");
	    //registry.addInterceptor(localeChangeInterceptor());
	    registry.addInterceptor(new CustomLocaleInterceptor());
	}
	
	@Bean(name="simpleMappingExceptionResolver")
	  public SimpleMappingExceptionResolver
	                  createSimpleMappingExceptionResolver() {
	    SimpleMappingExceptionResolver r =
	                new SimpleMappingExceptionResolver();

	    Properties mappings = new Properties();
	    mappings.setProperty("ArithmeticException", "error/error");
	    mappings.setProperty("Exception", "error/error");

	    r.setExceptionMappings(mappings);  // None by default
	    r.setDefaultErrorView("error");    // No default
	    r.setExceptionAttribute("ex");     // Default is "exception"
	    r.setWarnLogCategory("example.MvcLogger");     // No default
	    return r;
	  }
	
	@Bean
	public ObjectMapper objectMapper(){
		ObjectMapper objectMap = new ObjectMapper();
		objectMap.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		return objectMap;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        //stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(stringHttpMessageConverter);
        
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    final ObjectMapper objectMapper = new ObjectMapper();
	   // objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
	    converter.setObjectMapper(objectMapper);
	   // converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
	    converters.add(converter);
	    
	    Jackson2ObjectMapperBuilder builder = Jackson2ObjectMapperBuilder.xml();
        builder.indentOutput(true);
        converters.add(new MappingJackson2XmlHttpMessageConverter(builder.build()));
        
        super.configureMessageConverters(converters);
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.useJaf(false);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("json", MediaType.APPLICATION_JSON);
		//mediaTypes.put("xml11" , MediaType.APPLICATION_XML);
		configurer.mediaTypes(mediaTypes);
		configurer.ignoreAcceptHeader(true);
		//configurer.mediaType("json", MediaType.APPLICATION_JSON);
		
		
	}
	
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("demo");
	  }
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(2000000);
		return multipartResolver;
	}
}
