package com.marcossa.api.apirestproject.domain.dto;

import java.io.Serializable;

import com.marcossa.api.apirestproject.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoriaDTO(Categoria entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
