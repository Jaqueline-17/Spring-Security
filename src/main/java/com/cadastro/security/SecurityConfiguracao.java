package com.cadastro.security;


import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.cadastro.service.ClienteCustom;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Component
public class SecurityConfiguracao {
	

	private final ClienteCustom clienteCustom;
	
	public SecurityConfiguracao(ClienteCustom clienteCustom) {
		super();
		this.clienteCustom = clienteCustom;
	}

	@Bean
	PasswordEncoder protegerSenha() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain
	(HttpSecurity http) throws Exception {
		return http
				.csrf().disable()
				.authorizeRequests(auth ->
					auth.antMatchers("/").permitAll()
					.anyRequest().authenticated()
				)
				.userDetailsService(clienteCustom)
				.headers(headers -> headers.frameOptions().sameOrigin())
				.httpBasic(withDefaults())
				.build();
    }


}
