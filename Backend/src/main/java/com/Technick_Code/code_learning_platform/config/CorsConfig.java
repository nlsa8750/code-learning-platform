package com.Technick_Code.code_learning_platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Value;

@Configuration
public class CorsConfig {

    @Value("${cors-allowed-origins}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping().
                allowedOrigins(allowedOrigins).
                allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH").
                allowedHeaders("*").
                allowedCredentials(true).
                maxAge(3600);
            }
        }
    }

}