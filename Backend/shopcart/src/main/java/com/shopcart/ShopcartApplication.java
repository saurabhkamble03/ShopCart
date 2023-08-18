package com.shopcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ShopcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopcartApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {

	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("https://example.com",
	                            "https://www.example.com",
	                            "http://192.168.1.12:3000",
	                            "http://localhost:3000");
	        }
	    };
	}

}
