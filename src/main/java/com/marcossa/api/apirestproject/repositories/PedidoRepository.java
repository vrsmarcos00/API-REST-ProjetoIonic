package com.marcossa.api.apirestproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcossa.api.apirestproject.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
