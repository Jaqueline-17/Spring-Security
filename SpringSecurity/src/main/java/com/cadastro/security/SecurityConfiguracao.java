package com.cadastro.security;


import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Component
public class SecurityConfiguracao {
	
	@Bean
	PasswordEncoder protegerSenha() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain
	(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeRequests(auth -> auth
						.antMatchers("/", "/api/cliente").permitAll()
						.anyRequest().authenticated()
						)
				.headers(headers -> headers.frameOptions().sameOrigin())
				.httpBasic(withDefaults())
				.build();
    }


}
