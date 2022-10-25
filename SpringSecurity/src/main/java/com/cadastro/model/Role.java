package com.cadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import authentication.authentication.modules.user.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String tipo;
	
	public Role(Long id) {
		super();
		this.id = id;
	}
}
