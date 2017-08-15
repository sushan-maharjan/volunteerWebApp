package com.gemasu.volunteerWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:global.properties")
public class VolunteerWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolunteerWebAppApplication.class, args);
	}
}
