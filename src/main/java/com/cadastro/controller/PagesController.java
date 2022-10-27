package com.cadastro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/pages")
public class PagesController {
	
	// REQUEST TESTE
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/usuario")
	public String user() {
		return "Hello user";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adm() {
		return "Hello admin";
	}
}
