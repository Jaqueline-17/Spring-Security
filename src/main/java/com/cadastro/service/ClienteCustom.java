package com.cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cadastro.model.Cliente;
import com.cadastro.repositories.ClienteRepository;
import com.cadastro.security.ClienteSecurity;

@Service
public class ClienteCustom implements UserDetailsService{

	@Autowired
	ClienteRepository repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = repositorio.findByEmail_Acesso(email);
		if(cliente == null) {
			cliente = repositorio.findByEmail(email);
		}
		if(cliente == null) {
			throw new Error("Este Cliente não Existe.");
		}
		return new ClienteSecurity(cliente);
	}
	
}

