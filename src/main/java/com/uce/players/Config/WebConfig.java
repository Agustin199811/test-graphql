package com.uce.players.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/graphql") // Permite CORS específicamente en el endpoint GraphQL
                .allowedOrigins("http://localhost:3000") // Permitir solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permitir los métodos HTTP
                .allowedHeaders("*"); // Permitir todos los encabezados
    }
}
