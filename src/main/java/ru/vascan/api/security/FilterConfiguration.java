package ru.vascan.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean JWTFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        registration.setFilter(jwtAuthenticationFilter);
        List<String> urlPatters = new ArrayList<>();
        Collections.addAll(urlPatters, "/graphql");
        registration.setUrlPatterns(urlPatters);
        registration.setName("JWT-Auth");
        registration.setOrder(1);
        return registration;
    }
}
