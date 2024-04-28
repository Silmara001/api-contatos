package com.contatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contatos.dto.EnderecoDTO;
import com.contatos.dto.ResponseDTO;
import com.contatos.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/endereco")
@Api(value="Manipulação de endereços")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

	@PostMapping("/Associar")
	@ApiOperation(value="Associa um novo endereço a um contato existente")
	public ResponseEntity<ResponseDTO> associar(@RequestBody EnderecoDTO endereco) {
		return ResponseEntity.ok( enderecoService.associarEndereco(endereco) );
	}
	
	
	@PatchMapping("/Atualizar/{id}")
	@ApiOperation(value="Atualiza um endereço existente")
	public ResponseEntity<ResponseDTO> atualizar(@RequestBody EnderecoDTO endereco, @PathVariable("id") long id) {
		return ResponseEntity.ok( enderecoService.atualizar( id, endereco ) );
	}
	
}