package com.pepper.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pepper.cursomc.services.DBService;
import com.pepper.cursomc.services.EmailService;
import com.pepper.cursomc.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("@{spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			dbService.instanciateTestDataBase();				
		}
		return true;
	}
	
	@Bean
	public EmailService emailService() {		
		return new SmtpEmailService();
	}
}
