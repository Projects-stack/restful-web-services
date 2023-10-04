package com.in28minutes.rest.webservices.restfulwebservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authenticating all the requests
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // basic authentication with default config
        http.httpBasic(Customizer.withDefaults());

        // CSRF -> Post, Put
        http.csrf().disable();

        return http.build();
    }
}
