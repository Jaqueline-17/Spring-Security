package com.cadastro.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDto {
	
	  public Long idCliente;

	  public List<Long> idsRoles;
}
