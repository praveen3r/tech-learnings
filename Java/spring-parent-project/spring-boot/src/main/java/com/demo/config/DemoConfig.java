package com.demo.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="my")
public class DemoConfig {
	
	private String testStr;

	private List<String> servers;

	public List<String> getServers() {
		return this.servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

}
