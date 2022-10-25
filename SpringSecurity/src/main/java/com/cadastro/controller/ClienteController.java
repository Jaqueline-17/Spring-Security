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

import com.cadastro.model.Cliente;
import com.cadastro.service.impl.ClienteServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cliente")
public class ClienteController {
	
	//REQUEST TESTE
		@GetMapping("/home")
		public String hello() { 
			return "Hello Wolrd";
		}
	
	@Autowired
	private ClienteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = service.verClientes();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> selecionarCliente(@PathVariable("id") long ClienteId){
		return new ResponseEntity<Cliente>(service.selecionarCliente(ClienteId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(service.salvarCliente(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") long id, @RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(service.atualizarCliente(cliente, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletarCliente(@PathVariable("id") long id){
		service.deletarCliente(id);
		
		return new ResponseEntity<String>("Cliente Deletado", HttpStatus.OK);
	}
	
}
