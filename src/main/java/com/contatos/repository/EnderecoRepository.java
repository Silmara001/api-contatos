package com.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contatos.model.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
