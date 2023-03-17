package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

@RestController		// p/ indicar que isso é um controller (deve retornar um recurso)
public class ClienteController {
	
	/* AULA 2 STUFF
	
	@PersistenceContext		// injeta uma instância de EntityManager no atributo manager
	private EntityManager manager;	// EntityManager: interface do Jakarta Persistence usada p/ fazer operações com as entidades
	
	*/
	
	@Autowired(required = true)		// Annotation do Spring Data JPA: injeta uma instância de ClienteRepository (criada pelo Spring Data JPA em cima de uma implementação da respectiva interface em tempo real)*
	private ClienteRepository clienteRepository;
	
	// *: O @Autowired seria o equivalente a criar um construtor de ClienteController aqui com um parâmetro para a injeção de dependência
	// (o que poderia também ser feito pelo Lombok, através da anotação @AllArgsConstructor)

	@GetMapping("/clientes")	// p/ mapear o recurso definido como retorno deste método p/ a rota especificada
	public List<Cliente> listar() {
		return clienteRepository.findByName("João da Silva");
//		return clienteRepository.findAll();
		
		/* AULA 2 STUFF

		return manager.createQuery("from Cliente"*, Cliente.class)		// retorna objetos Cliente...
		.getResultList();	// ... em formato de lista
		
		// *: sintaxe de JPQL (Jakarta Persistence Query Language: SQL adaptado a entidades)
		// tradução do comando: "me dê aí todos os objetos da entidade Cliente"
		
		*/
	}
}
