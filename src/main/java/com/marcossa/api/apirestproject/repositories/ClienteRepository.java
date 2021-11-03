package com.marcossa.api.apirestproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcossa.api.apirestproject.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
