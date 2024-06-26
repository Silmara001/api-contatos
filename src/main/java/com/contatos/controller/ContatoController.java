package com.contatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.dto.ContatoDTO;
import com.contatos.dto.ResponseDTO;
import com.contatos.model.entity.Contato;
import com.contatos.service.ContatoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contatos")
@Api(value="Manipulação de contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping("/Listar")
	@ApiOperation(value="lista todos os contatos")
	public ResponseEntity<List<ContatoDTO>> coletarContato() {
		List<ContatoDTO> contatos = contatoService.listar();
		return ResponseEntity.ok( contatos );
	}
	
	@PutMapping("/Adicionar")
	@ApiOperation(value="Adiciona um novo contato.")
	public ResponseEntity<ResponseDTO> adicionarContato(@RequestBody Contato contato) {
		return ResponseEntity.ok( contatoService.adicionar(contato) );
	}
	
	@PostMapping("/Atualizar/{id}")
	@ApiOperation(value="Atualiza as informações de contato")
	public ResponseEntity<String> atualizarContato(@PathVariable("id") long id) {
		return ResponseEntity.ok( "Atualizou!" );
	}
	
	@DeleteMapping("/Apagar/{id}")
	@ApiOperation(value="Apaga um contato pelo ID.")
	public ResponseEntity<ResponseDTO> apagarContato(@PathVariable("id") long id) {
		return ResponseEntity.ok( contatoService.apagar( id ) );
	}

}