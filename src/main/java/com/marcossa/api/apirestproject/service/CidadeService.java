package com.marcossa.api.apirestproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcossa.api.apirestproject.domain.Cidade;
import com.marcossa.api.apirestproject.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findCidade(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}

}
