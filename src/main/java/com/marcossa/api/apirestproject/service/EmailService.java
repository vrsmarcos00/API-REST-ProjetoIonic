package com.marcossa.api.apirestproject.service;

import org.springframework.mail.SimpleMailMessage;

import com.marcossa.api.apirestproject.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
