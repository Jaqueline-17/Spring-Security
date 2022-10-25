package com.cadastro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.exeception.ErroException;
import com.cadastro.model.Pacote;
import com.cadastro.repositories.PacoteRepository;
import com.cadastro.service.PacoteService;

@Service
public class PacoteServiceImpl implements PacoteService{
	
	@Autowired
	private PacoteRepository pacoteRepository;
	
	@Override
	public Pacote salvarPacote(Pacote pacote) {
		return pacoteRepository.save(pacote);
	}
	
	@Override
	public List<Pacote> verPacotes(){
		return pacoteRepository.findAll();
	}
	
	@Override
	public Pacote selecionarPacote(long id) {
		return pacoteRepository.findById(id).orElseThrow(() -> 
		new ErroException("Pacode de Viagem não encontrado"));
	}
	
	@Override
	public Pacote atualizarPacote(Pacote pacote, long id) {
		Pacote pacoteAtual = pacoteRepository.findById(id).orElseThrow(
				() -> new ErroException("Este Pacode de Viagem não existe"));
		
		pacoteAtual.setTipo(pacote.getTipo());
		pacoteAtual.setPartida(pacote.getPartida());
		pacoteAtual.setDestino(pacote.getDestino());
		pacoteAtual.setHorSaida(pacote.getHorSaida());
		pacoteAtual.setHorChegada(pacote.getHorChegada());
		pacoteAtual.setTrasnporte(pacote.getTrasnporte());
		
		pacoteRepository.save(pacoteAtual);
		return pacoteAtual;
	}
	
	@Override
	public void deletarPacote(long id) {
		pacoteRepository.findById(id).orElseThrow(() -> 
		new ErroException("Pacote de Viagem não encontrado."));
		
		pacoteRepository.deleteById(id);
	}
	
	
}
