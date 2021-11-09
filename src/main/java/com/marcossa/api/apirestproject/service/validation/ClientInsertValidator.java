package com.marcossa.api.apirestproject.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcossa.api.apirestproject.domain.Cliente;
import com.marcossa.api.apirestproject.domain.dto.ClienteNewDTO;
import com.marcossa.api.apirestproject.domain.enums.TipoCliente;
import com.marcossa.api.apirestproject.repositories.ClienteRepository;
import com.marcossa.api.apirestproject.resources.exception.FieldMessage;
import com.marcossa.api.apirestproject.service.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("CpfOuCnpj", "CPF inválido"));
		}
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("CpfOuCnpj", "CNPJ inválido"));
		}
		
		Cliente aux = repository.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("Email", "Email já existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
