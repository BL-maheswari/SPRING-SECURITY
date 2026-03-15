package com.bl.school_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth

				.requestMatchers("/auth/**").permitAll()

				.requestMatchers("/admin/**").hasRole("ADMIN")

				.requestMatchers("/teacher/**").hasRole("TEACHER")

				.requestMatchers("/student/**").hasRole("STUDENT")

				.requestMatchers("/attendance/**").hasAnyRole("TEACHER", "ADMIN")

				.requestMatchers("/marks/**").hasRole("TEACHER")

				.anyRequest().authenticated()

		);

		return http.build();
	}
}
