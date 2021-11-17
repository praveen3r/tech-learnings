package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Bean
	public JasperReport fileUploadErrorRpt() throws Exception{
		JasperReport jasperReport = null;
		Resource resource = null;
		resource = resourceLoader.getResource("classpath:report/fileUploadError/Error.jrxml");
		jasperReport = getJasperRpt(resource);
		return jasperReport;
	}
	
	private JasperReport getJasperRpt(Resource resource) throws Exception{
		JasperReport jasperReport = null;
		final JasperDesign jasperDesign = JRXmlLoader.load(resource.getInputStream());
		jasperReport = JasperCompileManager.compileReport(jasperDesign);
		return jasperReport;
	}
}
