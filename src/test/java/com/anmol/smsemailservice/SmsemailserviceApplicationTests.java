package com.anmol.smsemailservice;

import java.sql.Timestamp;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anmol.smsemailservice.entites.EmailDelivary;
import com.anmol.smsemailservice.entites.Template;
import com.anmol.smsemailservice.repo.EmailDelivaryRepository;
import com.anmol.smsemailservice.repo.TemplateRepository;

@SpringBootTest
class SmsemailserviceApplicationTests {
	@Autowired
	private EmailDelivaryRepository emailDelivary;
	@Autowired
	private TemplateRepository templateRepository;

//	@Test
//	void contextssLoads() {
//
//		EmailDelivary delivary = new EmailDelivary();
//		delivary.setTo("anmol.dawne@gmail.com");
//		delivary.setCc("");
//		delivary.setBcc("");
//		delivary.setSubject("fsbdf");
//		delivary.setBody("fdhdatjryj");
//		delivary.setStatus("noT Sent");
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		
//		delivary.setCreatedTimeStamp(timestamp);
//		EmailDelivary save = emailDelivary.save(delivary);
//		System.out.println("Save---------"+save.toString());
//      
//	}

	@Test
	void tempateLoad() {

		Template template = new Template();
		template.setTempSubject("Thanks for purches | payment invoice $amount$");
		template.setTempBody("Hi there,"
				+ "Thank you for choosing ClearTax. We are pleased to conform your order $orderId$ and in receipt of payment for the same  ");
		templateRepository.save(template);
		System.out.println(template.toString());

	}

}
