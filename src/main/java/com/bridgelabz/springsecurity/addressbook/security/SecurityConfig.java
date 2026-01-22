package com.bridgelabz.springsecurity.addressbook.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager configureMemoryUser() {

		UserDetails user1 = User.withUsername("mahi").password("{noop}ma@123").roles("USER").build();

		UserDetails user2 = User.withUsername("admin").password("{bcrypt}admin123").roles("ADMIN").build();

		UserDetails user3 = User.withUsername("test").password("{noop}test123").roles("USER").build();

		return new InMemoryUserDetailsManager(user1, user2, user3);
	}
}
