package com.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name="data_nasc")
	@Convert(converter =  Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataNasc;
	
	@Column
	private String sexo;
	
	@Column
	private String cpf;
	
	@Column
	private String telefone;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@ManyToMany
	private List<Role> role;
	

}
