package com.cadastro.service;

import java.util.List;

import com.cadastro.model.Pacote;

public interface PacoteService {
	Pacote salvarPacote(Pacote pacote);
	List<Pacote> verPacotes();
	Pacote selecionarPacote(long id);
	Pacote atualizarPacote(Pacote pacote, long id);
	void deletarPacote(long id);
}
