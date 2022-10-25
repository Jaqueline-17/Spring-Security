package com.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
