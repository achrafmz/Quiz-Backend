package com.quiz.quiz.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Applique CORS à toutes les routes
                .allowedOrigins("http://localhost:3000")  // Autorise les requêtes depuis React
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Les méthodes autorisées
                .allowedHeaders("*");  // Autorise tous les en-têtes
    }
}
