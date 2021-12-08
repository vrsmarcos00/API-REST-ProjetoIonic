package com.marcossa.api.apirestproject.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcossa.api.apirestproject.domain.Cidade;
import com.marcossa.api.apirestproject.domain.Estado;
import com.marcossa.api.apirestproject.domain.dto.CidadeDTO;
import com.marcossa.api.apirestproject.domain.dto.EstadoDTO;
import com.marcossa.api.apirestproject.service.CidadeService;
import com.marcossa.api.apirestproject.service.EstadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@ApiOperation(value="Busca todos os Estados")
	@GetMapping
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDto = list.stream().map(x -> new EstadoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Busca todas as cidades")
	@GetMapping(value="/{estadoId}/cidades")
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId) {
		List<Cidade> list = cidadeService.findCidade(estadoId);
		List<CidadeDTO> listDto = list.stream().map(x -> new CidadeDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
