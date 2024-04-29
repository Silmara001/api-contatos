package com.contatos.dtocom.contatos.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import com.contatos.service.ContatoService;
import com.contatos.service.impl.ContatoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ContatoServiceImplTest {
	
	@InjectMocks
	private ContatoServiceImpl serviceContato;
	
	@Spy
	private ContatoService service;
	
	@Test
	void cadastrarContato() {
		
	}
	
}
