package com.cadastro.service;

import java.util.List;

import com.cadastro.model.Funcionario;

public interface FuncionarioService {
	Funcionario salvarFuncionario(Funcionario funcionario);
	List<Funcionario> verFuncionarios();
	Funcionario selecionarFuncionario(long id);
	Funcionario atualizarFuncionario(Funcionario funcionario, long id);
	void deletarFuncionario(long id);
}
