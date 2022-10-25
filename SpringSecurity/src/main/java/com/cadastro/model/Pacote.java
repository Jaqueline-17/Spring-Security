package com.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacote")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pacote {
	
	@Id
	@Column(name="id_pacote")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String tipo;
	
	@Column
	private String partida;
	
	@Column
	private String destino;
	
	@Column(name = "horario_saida")
	private String horSaida;
	
	@Column(name = "horario_chegada")
	private String horChegada;
	
	@Column
	private String trasnporte;
}
