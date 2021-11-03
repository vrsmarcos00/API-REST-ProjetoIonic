package com.marcossa.api.apirestproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcossa.api.apirestproject.domain.Pedido;
import com.marcossa.api.apirestproject.service.PedidoService;

@RestController
@RequestMapping(value="pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id){
		Pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
