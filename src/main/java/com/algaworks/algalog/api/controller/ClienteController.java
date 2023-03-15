package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController		// p/ indicar que isso é um controller (deve retornar um recurso)
public class ClienteController {
	@GetMapping("/clientes")	// p/ mapear o recurso definido como retorno deste método p/ a rota especificada
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setName("João");
		cliente1.setEmail("joaodascouves@algaworks.com");
		cliente1.setPhone("34 99999-1111");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setName("Maria");
		cliente2.setEmail("mariadasilva@algaworks.com");
		cliente2.setPhone("11 97777-2222");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
