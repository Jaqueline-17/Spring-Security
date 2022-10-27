package com.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cadastro.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByEmail(String email);
	
	@Query("SELECT u FROM Cliente u JOIN FETCH u.roles WHERE u.email = :email")
	Cliente findByEmail_Acesso(@Param("email") String email);




}
