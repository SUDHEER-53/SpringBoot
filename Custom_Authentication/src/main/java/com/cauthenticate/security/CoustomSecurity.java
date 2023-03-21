 package com.cauthenticate.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
@EnableWebSecurity
public class CoustomSecurity extends WebSecurityConfiguration{
	/*
	 * @Override
	 * protected void configure(HttpSecurity http) {
	 * http.authorizeRequests((requests)->request.anyRequest().authenticated());
	 * http.formLogin();
	 * http.httpBasic();
	 * 
	 * }
	 */
	
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.requestMatchers("/home").permitAll() 
		.requestMatchers("/balance").authenticated()
		.requestMatchers("/statement").authenticated()
		.requestMatchers("/loan").authenticated()
		.requestMatchers("/contact").permitAll();
	     http.formLogin();
         http.httpBasic();
	}

}
