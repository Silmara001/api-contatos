package com.contatos.service;

import com.contatos.dto.EnderecoDTO;
import com.contatos.dto.ResponseDTO;

public interface EnderecoService {
	public ResponseDTO associarEndereco(EnderecoDTO endereco);
	public ResponseDTO atualizar( long id, EnderecoDTO endereco);
}
