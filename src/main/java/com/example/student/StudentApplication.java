package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StudentApplication.class);

		// Hardcode the external config location
		Map<String, Object> defaultProps = new HashMap<>();
		defaultProps.put("spring.config.location", "file:/home/abhilash/Desktop/learning/learn-java/microservices/student-microservice/src/main/resources/application.properties");
		app.setDefaultProperties(defaultProps);
		app.run(args);
	}

}
