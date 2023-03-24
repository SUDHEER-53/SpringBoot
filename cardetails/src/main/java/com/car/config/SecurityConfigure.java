//package com.car.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigure {
//	
//	@Bean
//	public UserDetailsService userDetailService(PasswordEncoder encoder) {
//		UserDetails admin = User.withUsername("sudheer@gmail.com")
//				              .password(encoder.encode("sudheer@123"))
//				              .roles("ADMIN")
//				              .build();
//		
//		UserDetails  user =User.withUsername("krishna@gmail.com")
//				.password(encoder.encode("krishna@123"))
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(admin,user);
//	}
//	
//	
//	
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable()
//				.authorizeHttpRequests()
//				.requestMatchers("/api-car/**").permitAll()
////				.and()
////				.authorizeHttpRequests()
////				.requestMatchers("api-car/**").authenticated()
//				.and()
//				.formLogin()
//				.and()
//				.build();
//		
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//		
//	}
//	
//
//}
