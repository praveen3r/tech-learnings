/*
 * package com.demo.config;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.PropertySource; import
 * org.springframework.context.annotation.PropertySources;
 * 
 * @Configuration
 * 
 * @PropertySources({ @PropertySource(value = "classpath:demo.properties",
 * ignoreResourceNotFound = true),
 * 
 * @PropertySource(value = "classpath:demo-dev.properties",
 * ignoreResourceNotFound = true) }) public class CustomPropertyConfig {
 * 
 * @Value("${demo.text}") String value;
 * 
 * 
 * }
 */