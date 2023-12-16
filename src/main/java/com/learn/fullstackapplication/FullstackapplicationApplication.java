package com.learn.fullstackapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullstackapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackapplicationApplication.class, args);
	}
	
//	@Bean
//	public WebMvcConfigurer corConfigurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry corsRegistry) {
//				corsRegistry.addMapping("/**")
//				.allowedMethods("*")
//				.allowedOrigins("http://127.0.0.1:3000/");
//			}
//		};
//	}

}
