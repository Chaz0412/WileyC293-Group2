package com.grouptwo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.grouptwo")
@EntityScan(basePackages = "com.grouptwo.entity")
@EnableJpaRepositories(basePackages = "com.grouptwo.persistence")
public class GroupTwoProducerRestAPI {

	public static void main(String[] args) {
		SpringApplication.run(GroupTwoProducerRestAPI.class, args);
	}

}
