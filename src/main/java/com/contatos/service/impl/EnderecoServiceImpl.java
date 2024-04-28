package com.contatos.service.impl;

import com.contatos.dto.EnderecoDTO;
import com.contatos.dto.ResponseDTO;
import com.contatos.model.entity.Contato;
import com.contatos.model.entity.Endereco;
import com.contatos.repository.ContatoRepository;
import com.contatos.repository.EnderecoRepository;
import com.contatos.service.EnderecoService;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	
	private ContatoRepository contatoRepository;
	private EnderecoRepository enderecoRepository;
	
	public EnderecoServiceImpl( EnderecoRepository enderecoRepository, ContatoRepository contatoRepository ) {
		super();
		this.enderecoRepository = enderecoRepository;
		this.contatoRepository = contatoRepository;
	}

	@Override
	public ResponseDTO associarEndereco(EnderecoDTO endereco) {
		ResponseDTO response= new ResponseDTO();
		Optional<Contato> contato = contatoRepository.findById(endereco.getIdContato());
		
		if( contato.isPresent() ) {
			Endereco entity = new Endereco();
			entity.setRua( endereco.getRua() );
			entity.setCep( endereco.getCep() );
			entity.setNumero( endereco.getNumero() );
			entity.setIdContato( endereco.getIdContato() );
			
			entity = enderecoRepository.save(entity);
			
			response.setCode( entity.getId() );
			response.setMessage( " O endereço novo foi associado ao contato!" );
		} else {
			response.setCode( -1 );
			response.setMessage( " O ID contato informado não existe!" );
		}
		
		return response;
	}
	
	@Override
	public ResponseDTO atualizar( long id, EnderecoDTO endereco) {
		ResponseDTO response= new ResponseDTO();
		Optional<Endereco> end = enderecoRepository.findById(id);
		
		if( end.isPresent() ) {
			Endereco entity = new Endereco();
			entity.setId(id);
			entity.setRua( endereco.getRua() );
			entity.setCep( endereco.getCep() );
			entity.setNumero( endereco.getNumero() );
			entity.setIdContato( endereco.getIdContato() );
			
			entity = enderecoRepository.save(entity);
			
			response.setCode( entity.getId() );
			response.setMessage( " O endereço foi Atualizado!" );
		} else {
			response.setCode( -1 );
			response.setMessage( " O ID de endereço informado não existe!" );
		}
		
		return response;
	}
}
