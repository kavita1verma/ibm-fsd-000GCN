package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}

}
