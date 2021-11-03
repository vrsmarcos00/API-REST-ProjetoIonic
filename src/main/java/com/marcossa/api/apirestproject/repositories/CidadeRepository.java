package com.marcossa.api.apirestproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcossa.api.apirestproject.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
