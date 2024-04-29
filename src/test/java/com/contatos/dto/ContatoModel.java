package com.contatos.dto;

import java.time.LocalDate;

public class ContatoModel {
	
	public static final ContatoDTO criarContato ( ) {
		return ContatoDTO.builder()
				.id( 1L )
				.nome("Pedro Carlos")
				.dataNasc(LocalDate.now())
				.email("test@test.com")
				.telefone("119562947")
				.enderecos(EnderecoModel.criarListaEndereco( 1L ) )
				.build();
	}
	
	public static final ContatoDTO criarContatoInvalido ( ) {
		return ContatoDTO.builder()
				.id( 1L )
				.nome(null)
				.dataNasc(LocalDate.now())
				.email("test@test.com")
				.telefone("119562947")
				.enderecos(EnderecoModel.criarListaEndereco( 1L ) )
				.build();
	}
	
}
