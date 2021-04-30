package com.np.jpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@RefreshScope
public class DBConfigProperties {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.userName}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;
}
