package com.contatos.dto;

import java.io.Serializable;
import com.contatos.model.entity.Endereco;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String rua;
	private String numero;
	private String cep;
	private Long idContato;
	
	public EnderecoDTO() {}
	
	public EnderecoDTO(Long id, String rua, String numero, String cep, Long idContato) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.idContato = idContato;
	}
	
	public EnderecoDTO(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.cep = endereco.getCep();
		this.idContato = endereco.getIdContato();
	}

	@Override
	public String toString() {
		return "EnderecoDTO [id=" + id + ", rua=" + rua + ", numero=" + numero + ", cep=" + cep + "]";
	}
	
}
