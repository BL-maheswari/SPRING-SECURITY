package com.bl.basicauthentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/secure/users/").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/secure/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        )
                        .httpBasic(customizer -> {}) // ✅ new httpBasic style
                        .csrf(csrf -> csrf.disable()); // ✅ new csrf disable style

        return http.build();
	}
	@Bean
    public UserDetailsService users(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("user")
                        .password("user")
                        .roles("USER")
                        .build()
        );
    }

	@Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
