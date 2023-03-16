package com.algaworks.algalog.domain.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
// ^ Annotation do Lombok que trata dos métodos equals e hashCode.
// O argumento onlyExplicitlyIncluded determina que seja incluído manualmente - por meio de outra anotação (linha 23) -
// o atributo que determinará a igualdade entre duas instâncias da classe Cliente.
@Getter					// \ Annotations do Lombok que cuidam da geração de getters e setters, deixando o código em si mais limpo
@Setter					// /
@Entity		// Indica que isso aqui é uma entidade (equivale a uma tabela no BD)
@Table(name = "cliente")		// usaríamos isso se o nome da tabela fosse diferente do nome da classe
public class Cliente {
	
	@EqualsAndHashCode.Include		// complemento à anotação EqualsAndHashCode da linha 13; o ID determinará a igualdade de instâncias diferentes da classe Cliente.
	@Id		// mapeia isso como id (chave primária)
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// indica que o BD se responsabilizará pela geração da chave (no caso, pela propriedade AUTO_INCREMENT)
	private Long id;
	
//	@Column(name = "client_name")	// se o nome do atributo fosse diferente do nome de sua coluna equivalente na tabela, usaríamos essa anotação p/ fazer o mapeamento correto
	private String name;
	
	private String email;
	
	private String phone;
}
