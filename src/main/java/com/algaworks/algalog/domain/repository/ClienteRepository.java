package com.algaworks.algalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algalog.domain.model.Cliente;

@Repository		// anotação para definir este componente Spring como um repositório (algo que gerencia entidades)
// Componente Spring: Um tipo cujas instâncias são gerenciadas pelo próprio container do Spring
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByName(String name);	// O Spring Data JPA nos fornece uma implementação disso aqui em tempo de execução,
											// sem que especifiquemos nada. Mágico.
											// ^ para isso, deve-se seguir uma convenção de nomenclatura do método.
											// Neste caso, findByName = findBy (query) + nome do atributo (name)
	
	List<Cliente> findByNameContaining(String nome);		// equivalente ao LIKE do SQL
}
