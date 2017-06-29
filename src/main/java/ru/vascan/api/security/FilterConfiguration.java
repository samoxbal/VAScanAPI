package ru.vascan.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class FilterConfiguration {

    @Value("${JWT.secret}")
    private String secret;

    @Value("${JWT.issuer}")
    private String issuer;

    @Bean
    public FilterRegistrationBean JWTFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        registration.setFilter(jwtAuthenticationFilter);
        registration.addUrlPatterns("/*");
        registration.addInitParameter("secret", secret);
        registration.addInitParameter("issuer", issuer);
        registration.setName("JWT-Auth");
        registration.setOrder(1);
        return registration;
    }
}
