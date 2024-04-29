package com.contatos.dto;

import java.util.ArrayList;
import java.util.List;

public class EnderecoModel {
	
	public static final EnderecoDTO criarEndereco ( long idContato ) {
		return EnderecoDTO.builder()
				.id( 1L )
				.rua( "Rua Cristovão" )
				.cep( "09846234")
				.numero( "23B" )
				.idContato( idContato )
				.build();
	}
	
	public static final List<EnderecoDTO> criarListaEndereco ( long idContato ) {
		List<EnderecoDTO> lista = new ArrayList<>();
		
		lista.add( EnderecoDTO.builder()
				.id( 1L )
				.rua( "Rua Cristovão" )
				.cep( "09846234")
				.numero( "23B" )
				.idContato( idContato )
				.build()
				);
		
		lista.add( EnderecoDTO.builder()
				.id( 2L )
				.rua( "Rua Joana" )
				.cep( "45646234")
				.numero( "2C" )
				.idContato( idContato )
				.build()
				);
		
		return lista;
	}
	
	public static final EnderecoDTO criarEnderecoInvalido ( long idContato ) {
		return EnderecoDTO.builder()
				.id( 1L )
				.rua( "Rua Cristovão" )
				.cep( "098462AD")
				.numero( "098A" )
				.idContato( idContato )
				.build();
	}
	
	public static final EnderecoDTO criarEnderecoCamposNulo ( ) {
		return EnderecoDTO.builder()
				.id( 1L )
				.build();
	}
	
	public static final EnderecoDTO criarEnderecoCamposVazio ( long idContato ) {
		return EnderecoDTO.builder()
				.id( 1L )
				.rua( "" )
				.cep( "")
				.numero( "" )
				.idContato( idContato )
				.build();
	}

}
