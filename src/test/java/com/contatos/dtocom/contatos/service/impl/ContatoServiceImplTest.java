package com.contatos.dtocom.contatos.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.contatos.dto.ContatoDTO;
import com.contatos.dto.ContatoModel;
import com.contatos.dto.EnderecoDTO;
import com.contatos.dto.EnderecoModel;
import com.contatos.dto.ResponseDTO;
import com.contatos.model.entity.Contato;
import com.contatos.model.entity.Endereco;
import com.contatos.repository.ContatoRepository;
import com.contatos.repository.EnderecoRepository;
import com.contatos.service.ContatoService;
import com.contatos.service.impl.ContatoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ContatoServiceImplTest {
	@MockBean
	private ContatoRepository contatoRepository;
	
	@MockBean
	private EnderecoRepository enderecoRepository;
	
	@Spy
	private ContatoService service;
	
	@Autowired
	@InjectMocks
	private ContatoServiceImpl contatoServiceImpl;
	
	@BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        this.contatoServiceImpl = mock(ContatoServiceImpl.class);
        this.contatoRepository = mock(ContatoRepository.class);
        this.enderecoRepository = mock(EnderecoRepository.class);
    }
	
	@Test
	void adicionarContato() {
		ResponseDTO response = new ResponseDTO(1L, "Contato Salvo!");
		ContatoDTO contatoModel = ContatoModel.criarContato();
		List<EnderecoDTO> enderecosDto = EnderecoModel.criarListaEndereco( contatoModel.getId() );
		Contato contatoDao = new Contato(contatoModel, enderecosDto);
		
		List<Endereco> enderecosDao = new ArrayList<>();
		enderecosDto.forEach( item -> enderecosDao.add( new Endereco( item, contatoDao.getId() ) ) );
		contatoDao.setEnderecos( enderecosDao );
		
		doReturn(response).when(contatoServiceImpl).adicionar(contatoDao);
		response = contatoServiceImpl.adicionar(contatoDao);
		
		assertEquals("Contato Salvo!", response.getMessage());
	}
}
