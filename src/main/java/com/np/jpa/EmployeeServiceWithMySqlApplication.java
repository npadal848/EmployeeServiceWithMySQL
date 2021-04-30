package com.np.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class,
		ManagementWebSecurityAutoConfiguration.class })
//@EnableCaching
@EnableJpaRepositories
public class EmployeeServiceWithMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceWithMySqlApplication.class, args);
	}

}
