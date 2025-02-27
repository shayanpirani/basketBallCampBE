package com.example.basketBallCamp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/kids/**").permitAll() // Allow public access
                .anyRequest().authenticated()
                .and()
                .csrf().disable()  // Disable CSRF for testing (enable in production)
                .formLogin().disable()  // Disable form-based authentication
                .httpBasic().disable(); // Disable basic authentication

        return http.build();
    }
}
