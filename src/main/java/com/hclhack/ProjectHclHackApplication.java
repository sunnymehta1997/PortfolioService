package com.hclhack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ProjectHclHackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectHclHackApplication.class, args);
	}

}
