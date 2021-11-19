package com.marcossa.api.apirestproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.api.apirestproject.domain.Estado;
import com.marcossa.api.apirestproject.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll() {
		return estadoRepository.findAllByOrderByNome();
	}

}
