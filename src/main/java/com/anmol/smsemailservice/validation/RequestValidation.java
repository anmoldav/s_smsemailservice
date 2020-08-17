package com.anmol.smsemailservice.validation;

import org.springframework.stereotype.Component;

import com.anmol.smsemailservice.reqresp.MailRequest;
import com.google.common.base.Strings;

@Component
public class RequestValidation {

	public void validateRequest(MailRequest mailRequest) {

		if (mailRequest == null)
			throw new IllegalArgumentException("request can not be empty");

		if (Strings.isNullOrEmpty(mailRequest.getFrom()))
			throw new IllegalArgumentException("From Can naot be Null or Empty");
		if (Strings.isNullOrEmpty(mailRequest.getTo()))
			throw new IllegalArgumentException("To can not be Null or Empty");
		if (Strings.isNullOrEmpty(mailRequest.getSubject()))
			throw new IllegalArgumentException("Subject can not be Null or Empty");
		if (Strings.isNullOrEmpty(mailRequest.getBody()))
			throw new IllegalArgumentException("Body Can not be Null or Empty");

	}

}
