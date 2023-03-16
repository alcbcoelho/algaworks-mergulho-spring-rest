package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController		// p/ indicar que isso é um controller (deve retornar um recurso)
public class ClienteController {
	
	@PersistenceContext		// injeta uma instância de EntityManager no atributo manager
	private EntityManager manager;	// EntityManager: interface do Jakarta Persistence usada p/ fazer operações com as entidades

	@GetMapping("/clientes")	// p/ mapear o recurso definido como retorno deste método p/ a rota especificada
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente"/***/, Cliente.class)		// retorna objetos Cliente...
		.getResultList();	// ... em formato de lista
		
		// *: sintaxe de JPQL (Jakarta Persistence Query Language: SQL adaptado a entidades)
		// tradução do comando: "me dê aí todos os objetos da entidade Cliente"
	}
}
