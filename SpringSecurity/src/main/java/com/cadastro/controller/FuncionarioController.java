package com.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.model.Funcionario;
import com.cadastro.service.impl.FuncionarioServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll(){
		List<Funcionario> funcionarios = service.verFuncionarios();
		return ResponseEntity.ok().body(funcionarios);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Funcionario> selecionarFuncionario(@PathVariable("id") long FuncionarioId){
		return new ResponseEntity<Funcionario>(service.selecionarFuncionario(FuncionarioId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.salvarFuncionario(funcionario), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable("id") long id, @RequestBody Funcionario funcionario){
		return new ResponseEntity<Funcionario>(service.atualizarFuncionario(funcionario, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletarFuncionario(@PathVariable("id") long id){
		service.deletarFuncionario(id);
		
		return new ResponseEntity<String>("Funcionario Deletado", HttpStatus.OK);
	}
}
