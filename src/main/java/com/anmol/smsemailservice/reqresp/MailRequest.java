package com.anmol.smsemailservice.reqresp;

import java.util.ArrayList;
import java.util.List;

public class MailRequest {

	private String from;
	//private String to;

	private String subject;
	private String body;
	private List<String>  to= new ArrayList<String>();
     private List<String> cc= new ArrayList<String>();
     private List<String> bcc=new ArrayList<String>();

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String>  getTo() {
		return to;
	}

	/*
	 * public void setTo(String to) { this.to = to; }
	 */
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
}
