package com.np.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class EmployeeServiceWithMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceWithMySqlApplication.class, args);
	}

}
