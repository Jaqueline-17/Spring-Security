package com.cadastro.service;

import com.cadastro.model.Cliente;

import java.util.List;

public interface ClienteService {
	Cliente salvarCliente(Cliente cliente);
	List<Cliente> verClientes();
	Cliente selecionarCliente(long id);
	Cliente atualizarCliente(Cliente Cliente, long id);
	void deletarCliente(long id);
}
