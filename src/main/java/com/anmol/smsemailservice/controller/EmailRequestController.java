package com.anmol.smsemailservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.smsemailservice.reqresp.ErrorResponse;
import com.anmol.smsemailservice.reqresp.MailRequest;
import com.anmol.smsemailservice.reqresp.MailResponse;
import com.anmol.smsemailservice.utils.EmailUtility;
import com.anmol.smsemailservice.validation.RequestValidation;

@RestController
@RequestMapping("/mail")
public class EmailRequestController {

	@Autowired
	private EmailUtility emailUtility;
	@Autowired
	private RequestValidation requestValidation;

	@PostMapping("/send")
	public ResponseEntity<Object> sendmail(@RequestBody MailRequest mailRequest) {
		requestValidation.validateRequest(mailRequest);

		String from = mailRequest.getFrom();
		System.out.println("" + from);

		List<String> to = mailRequest.getTo();
		System.out.println("" + to);
		List<String> cc = mailRequest.getCc();
        System.out.println("" + cc);
        List<String> bcc=mailRequest.getBcc();
        System.out.println(""+bcc);
		String subject = mailRequest.getSubject();
		System.out.println("" + subject);
		String body = mailRequest.getBody();
		System.out.println("" + body);

		try {
			emailUtility.sendmail(mailRequest);
			MailResponse response = new MailResponse();
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
