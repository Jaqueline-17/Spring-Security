package com.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.model.Cliente;
import com.cadastro.model.ClienteDto;
import com.cadastro.model.Role;
import com.cadastro.repositories.ClienteRepository;


@Service
public class ClienteRoleService {
	
	@Autowired
	ClienteRepository repositorio;
	
	public Cliente execute(ClienteDto clienteDto) {

	    Optional<Cliente> clienteExiste = repositorio.findById(clienteDto.idCliente);
	    List<Role> roles = new ArrayList<>();

	    if (clienteExiste.isEmpty()) {
	      throw new Error("Cliente não encontrado!");
	    }

	    roles = clienteDto.getIdsRoles().stream().map(role -> {
	        return new Role(role);
	      }).collect(Collectors.toList());

	    Cliente cliente = clienteExiste.get();

	    cliente.setRoles(roles);

	    repositorio.save(cliente);

	    return cliente;

	  }
}
