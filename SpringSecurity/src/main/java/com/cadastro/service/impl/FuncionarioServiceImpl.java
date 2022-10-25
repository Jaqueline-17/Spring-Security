package com.cadastro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.exeception.ErroException;
import com.cadastro.model.Funcionario;
import com.cadastro.repositories.FuncionarioRepository;
import com.cadastro.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioRepository funcRepository;
	
	@Override
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		return funcRepository.save(funcionario);
	}
	
	@Override
	public List<Funcionario> verFuncionarios(){
		return funcRepository.findAll();
	}
	
	@Override
	public Funcionario selecionarFuncionario(long id) {
		return funcRepository.findById(id).orElseThrow(() -> 
		new ErroException("Funcionario não encontrado"));
	}
	
	@Override
	public Funcionario atualizarFuncionario(Funcionario funcionario, long id) {
		Funcionario funcionarioAtual = funcRepository.findById(id).orElseThrow(
				() -> new ErroException("Este Funcionário não Existe"));
		
		funcionarioAtual.setNome(funcionario.getNome());
		funcionarioAtual.setNivelAcess(funcionario.getNivelAcess());
		funcionarioAtual.setAcesso(funcionario.getAcesso());
		funcionarioAtual.setSenha(funcionario.getSenha());

		funcRepository.save(funcionarioAtual);
		return funcionarioAtual;
	}
	
	@Override
	public void deletarFuncionario(long id) {
		funcRepository.findById(id).orElseThrow(() -> 
		new ErroException("Funcionário não encontrado."));
		
		funcRepository.deleteById(id);
	}
}
