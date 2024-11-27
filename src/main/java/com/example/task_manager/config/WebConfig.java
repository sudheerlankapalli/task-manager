package com.example.task_manager.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Allow cross-origin requests to all API endpoints
                .allowedOrigins("http://localhost:3000")
                .allowedOrigins("https://taskmanager-demo.netlify.app/")// Your React app's URL during development
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("*");  // Allow all headers
    }
}

