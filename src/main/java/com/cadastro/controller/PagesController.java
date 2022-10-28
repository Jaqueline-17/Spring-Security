package com.cadastro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@CrossOrigin("*")
@RequestMapping("/pages")
public class PagesController {
	
	// REQUEST TESTE
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/destinos")
	public String destinos() {
		return "destinos";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adm() {
		return "Hello admin";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
}
