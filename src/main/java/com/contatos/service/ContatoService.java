package com.contatos.service;

import java.util.List;

import com.contatos.dto.ContatoDTO;
import com.contatos.dto.ResponseDTO;
import com.contatos.model.entity.Contato;

public interface ContatoService {
	public ResponseDTO adicionar(Contato contato);
	public ResponseDTO apagar(long contato);
	public List<ContatoDTO> listar();
}
