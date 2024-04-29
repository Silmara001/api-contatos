package com.contatos.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.contatos.model.entity.Contato;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataNasc;
	private List<EnderecoDTO> enderecos = new ArrayList<>();
	
	public ContatoDTO() {}
	
	public ContatoDTO(Long id, String nome, String email, String telefone, LocalDate dataNasc,
			List<EnderecoDTO> enderecos) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.enderecos = enderecos;
	}
	
	public ContatoDTO(Contato contato, List<EnderecoDTO> enderecosDTO) {
		super();
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.email = contato.getEmail();
		this.telefone = contato.getTelefone();
		this.dataNasc = contato.getDataNasc();
		this.enderecos = enderecosDTO;
	}

	@Override
	public String toString() {
		return "ContatoDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", dataNasc="
				+ dataNasc + ", enderecos=" + enderecos + "]";
	}
	
}
