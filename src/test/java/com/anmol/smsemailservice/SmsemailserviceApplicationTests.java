package com.anmol.smsemailservice;

import java.sql.Timestamp;

import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anmol.smsemailservice.entites.EmailDelivary;
import com.anmol.smsemailservice.repo.EmailDelivaryRepository;


@SpringBootTest
class SmsemailserviceApplicationTests {
	@Autowired
	EmailDelivaryRepository emailDelivary;

	@Test
	void contextssLoads() {

		EmailDelivary delivary = new EmailDelivary();
		delivary.setTo("anmol.dawne@gmail.com");
		delivary.setCc("");
		delivary.setBcc("");
		delivary.setSubject("fsbdf");
		delivary.setBody("fdhdatjryj");
		delivary.setStatus("noT Sent");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		delivary.setCreatedTimeStamp(timestamp);
		EmailDelivary save = emailDelivary.save(delivary);
		System.out.println("Save---------"+save.toString());
      
	}
	
	
	
	
	
	

}
