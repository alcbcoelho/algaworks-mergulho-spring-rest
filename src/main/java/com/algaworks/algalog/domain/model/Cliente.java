package com.algaworks.algalog.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter		// annotations do Lombok que cuidam da geração de getters e setters, deixando o código em si mais limpo
@Setter
public class Cliente {
	private Long id;
	private String name;
	private String email;
	private String phone;
}
