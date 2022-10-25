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

import com.cadastro.model.Pacote;
import com.cadastro.service.impl.PacoteServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("api/pacote")
public class PacoteController {
	
	@Autowired
	private PacoteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<List<Pacote>> findAll(){
		List<Pacote> pacotes = service.verPacotes();
		return ResponseEntity.ok().body(pacotes);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Pacote> selecionarCliente(@PathVariable("id") long PacoteId){
		return new ResponseEntity<Pacote>(service.selecionarPacote(PacoteId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pacote> salvarPacote(@RequestBody Pacote pacote){
		return new ResponseEntity<Pacote>(service.salvarPacote(pacote), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Pacote> atualizarPacote(@PathVariable("id") long id, @RequestBody Pacote pacote){
		return new ResponseEntity<Pacote>(service.atualizarPacote(pacote, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletarPacote(@PathVariable("id") long id){
		service.deletarPacote(id);
		
		return new ResponseEntity<String>("Pacote de Viagem Deletado", HttpStatus.OK);
	}
}
