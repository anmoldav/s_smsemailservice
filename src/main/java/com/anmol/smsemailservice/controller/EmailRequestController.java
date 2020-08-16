package com.anmol.smsemailservice.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.smsemailservice.reqresp.ErrorResponse;
import com.anmol.smsemailservice.reqresp.MailRequest;
import com.anmol.smsemailservice.reqresp.MailResponse;
import com.anmol.smsemailservice.utils.EmailUtility;

@RestController
@RequestMapping("/mail")
public class EmailRequestController {

	@Autowired
	private EmailUtility emailUtility;
	@PostMapping("/send")
	public ResponseEntity<Object> sendmail(@RequestBody MailRequest mailRequest) {
		String from = mailRequest.getFrom();
		System.out.println("" + from);
		String to = mailRequest.getTo();
		System.out.println("" + to);
		String subject = mailRequest.getSubject();
		System.out.println("" + subject);
		String body = mailRequest.getBody();
		System.out.println("" + body);
		
			try {
				emailUtility.sendmail(mailRequest);
				MailResponse  response = new MailResponse();
				response.setMessage("Email sent");
				return new ResponseEntity<Object>(response, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ErrorResponse errorResponse = new ErrorResponse(206, e.getMessage());
				return new ResponseEntity<Object>(errorResponse, HttpStatus.PARTIAL_CONTENT);
			} 
			
	}

	
}
