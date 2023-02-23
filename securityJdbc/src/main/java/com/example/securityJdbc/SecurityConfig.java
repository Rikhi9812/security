package com.example.securityJdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	@Autowired
    DataSource dataSource;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/home").hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated()
			.and()
			.formLogin();
		
		return http.build();
	}
	
	
	 @Bean
	    public UserDetailsManager users() {
	        
	        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
	        return users;
	    }
	    
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
