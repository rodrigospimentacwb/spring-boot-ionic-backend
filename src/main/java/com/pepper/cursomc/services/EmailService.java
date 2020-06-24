package com.pepper.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pepper.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
