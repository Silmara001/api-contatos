package com.contatos.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.contatos.dto.ContatoDTO;
import com.contatos.dto.EnderecoDTO;
import com.contatos.dto.ResponseDTO;
import com.contatos.model.entity.Contato;
import com.contatos.model.entity.Endereco;
import com.contatos.repository.ContatoRepository;
import com.contatos.repository.EnderecoRepository;
import com.contatos.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

	private ContatoRepository contatoRepository;
	private EnderecoRepository enderecoRepository;
	
	public ContatoServiceImpl(ContatoRepository contatoRepository, EnderecoRepository enderecoRepository) {
		super();
		this.contatoRepository = contatoRepository;
		this.enderecoRepository = enderecoRepository;
	}
	
	@Override
	public ResponseDTO adicionar( Contato contato ) {
		ResponseDTO response = new ResponseDTO();
		
		contato = contatoRepository.save( contato );
		List<Endereco> listEnderecos = contato.getEnderecos();
		
		if(contato != null)
			for( Endereco item: listEnderecos) {
				item.setIdContato( contato.getId() );
				enderecoRepository.save( item );
			}
		
		response.setCode( contato.getId() );
		response.setMessage( "Contato Salvo!" );
		return response;
	}

	@Override
	public ResponseDTO apagar(long id) {
		ResponseDTO response = new ResponseDTO();
		Optional<Contato> contato = contatoRepository.findById(id);
		
		if(contato.isPresent()) {
			contatoRepository.deleteById(id);
			response.setCode(id);
			response.setMessage("Apagou o contato!");
		} else {
			response.setCode(-1);
			response.setMessage("O ID de contato informado não existe!");
		}

		return response;
	}
	
	@Override
	public List<ContatoDTO> listar() {
		List<ContatoDTO> listContatos = new ArrayList<>();
		List<Contato> contatos = contatoRepository.findAll();
		
		for(Contato item: contatos) {
			List<EnderecoDTO> enderecosDTO = new ArrayList<>();
			
			if( item.getEnderecos() != null && !item.getEnderecos().isEmpty() )
				item.getEnderecos().forEach( end -> enderecosDTO.add( new EnderecoDTO( end ) ) );
			
			ContatoDTO contato = new ContatoDTO( item, enderecosDTO );
			listContatos.add( contato );
		}
		return listContatos;
	}

}
