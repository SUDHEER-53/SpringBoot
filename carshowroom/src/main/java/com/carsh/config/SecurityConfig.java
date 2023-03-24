package com.carsh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//authentication
	@Bean
	public UserDetailsService userservice (PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("abc@gmail.com")
		                 .password(encoder.encode("abc@123"))
		                 .roles("ADMIN")
		                 .build();
		
		UserDetails user =User.withUsername("bcd@gmail.com")
				                .password(encoder.encode("bcd@123"))
				                .roles("USER")
				                .build();
		
		return new  InMemoryUserDetailsManager(admin,user);
	}
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		
	return	http.csrf().disable()
		           .authorizeHttpRequests()
		           .requestMatchers("/api/showroom/welcome").permitAll()
		           .requestMatchers("/api/showroom/end").permitAll()
		           .and()
		           .authorizeHttpRequests()
		           .requestMatchers("/api/showroom/**").authenticated()
		           .and().formLogin()
		           .and()
		           .build();
		           
		
		
		
	}
	@Bean
	public PasswordEncoder  passwordEnoder() {
		return  new  BCryptPasswordEncoder();
	}
	
	}


