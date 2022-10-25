package com.cadastro.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cadastro.model.Cliente;

public class ClienteSecurity implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String senha;
	private Collection<? extends GrantedAuthority> autorizacao;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacao;
	}
	
	public ClienteSecurity(Cliente cliente) {
		this.username = cliente.getEmail();
		this.senha = cliente.getSenha();
		try {
				this.autorizacao = cliente.getRole().stream().map(role -> {
					return new  SimpleGrantedAuthority
							("Tipo de Acesso:" + role.getTipo());
				}).collect(Collectors.toList());
			}catch(Exception e) {
				this.autorizacao = new ArrayList<>();
			}
		}
	
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
