package com.my.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyBatchProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyBatchProjectApplication.class, args);
	}

}
