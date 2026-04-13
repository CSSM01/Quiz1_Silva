package com.practice.quiz_silva_cristian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails driver = User.withDefaultPasswordEncoder()
                .username("driver")
                .password("driver123")
                .roles("DRIVER")
                .build();

        return new InMemoryUserDetailsManager(admin, driver);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // ADMIN puede manejar usuarios y crear drivers
                        .requestMatchers("/users/**", "/drivers/crear").hasRole("ADMIN")
                        // DRIVER solo puede ver drivers
                        .requestMatchers("/drivers/listar", "/drivers/**").hasRole("DRIVER")
                        // cualquier otra petición requiere login
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}