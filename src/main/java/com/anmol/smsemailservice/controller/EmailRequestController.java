package com.anmol.smsemailservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anmol.smsemailservice.entites.EmailDelivary;
import com.anmol.smsemailservice.entites.Template;
import com.anmol.smsemailservice.repo.TemplateRepository;
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
	@Autowired
	private TemplateRepository templateRepository;

	@PostMapping("/send")
	public ResponseEntity<Object> sendmail(@RequestBody MailRequest mailRequest) {
		requestValidation.validateRequest(mailRequest);
		int templateNo = mailRequest.getTemplateNo();
		HashMap<String, String> paramaters = mailRequest.getParameters();
		HashMap<String, String> subjectpara = mailRequest.getSubjectParameters();

		String from = mailRequest.getFrom();
		System.out.println("" + from);

		List<String> to = mailRequest.getTo();
		System.out.println("" + to);
		List<String> cc = mailRequest.getCc();
		System.out.println("" + cc);
		List<String> bcc = mailRequest.getBcc();
		System.out.println("" + bcc);
		System.out.println("parameters: " + paramaters.toString());
		System.out.println("subjpara:"+subjectpara.toString());

		Optional<Template> optional = templateRepository.findById(mailRequest.getTemplateNo());
		String tempBody = "";
		String tempSubject = "";

		if (optional.isPresent()) {
			Template template = optional.get();
			System.out.println("Template obj--" + template.toString());
			tempBody = template.getTempBody();
			for (Map.Entry<String, String> entry : paramaters.entrySet()) {
				String key = "$" + entry.getKey() + "$";
				System.out.println("key:" + key);
				tempBody = tempBody.replace(key, entry.getValue());
			}
			System.out.println(" Template body----" + tempBody);

			tempSubject = template.getTempSubject();
			for (Map.Entry<String, String> subentry : subjectpara.entrySet()) {
				String key = "$" + subentry.getKey() + "$";
				System.out.println("kay:" + key);
				tempSubject = tempSubject.replace(key, subentry.getValue());
			}
			System.out.println("Template subject:" + tempSubject);

		} else {
			throw new IllegalArgumentException("Templat not found");
		}
		
		

		try {
			emailUtility.sendmail(mailRequest, tempBody,tempSubject);
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
