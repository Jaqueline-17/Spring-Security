package com.cadastro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cadastro.exeception.ErroException;
import com.cadastro.model.Cliente;
import com.cadastro.repositories.ClienteRepository;
import com.cadastro.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	private BCryptPasswordEncoder protegerSenha() {
		return new BCryptPasswordEncoder( );
	}
	
	
	@Override
	public Cliente salvarCliente(Cliente cliente) {
		cliente.setSenha(protegerSenha().encode(cliente.getSenha()));
		return clienteRepository.save(cliente);
	}
	
	@Override
	public List<Cliente> verClientes(){
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente selecionarCliente(long id) {
		return clienteRepository.findById(id).orElseThrow(() -> 
		new ErroException("Cliente não encontrado"));
	}
	
	@Override
	public Cliente atualizarCliente(Cliente cliente, long id) {
		Cliente clienteAtual = clienteRepository.findById(id).orElseThrow(
				() -> new ErroException("Este Cliente não Existe"));
		
		clienteAtual.setNome(cliente.getNome());
		clienteAtual.setDataNasc(cliente.getDataNasc());
		clienteAtual.setSexo(cliente.getSexo());
		clienteAtual.setCpf(cliente.getCpf());
		clienteAtual.setTelefone(cliente.getTelefone());
		clienteAtual.setEmail(cliente.getEmail());
		clienteAtual.setSenha(cliente.getSenha());

		clienteRepository.save(clienteAtual);
		return clienteAtual;
	}
	
	@Override
	public void deletarCliente(long id) {
		clienteRepository.findById(id).orElseThrow(() -> 
		new ErroException("Cliente não encontrado."));
		
		clienteRepository.deleteById(id);
	}
	
}
