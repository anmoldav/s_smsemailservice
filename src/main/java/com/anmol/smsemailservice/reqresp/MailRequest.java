package com.anmol.smsemailservice.reqresp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailRequest {

	private String from;
	//private String to;

	private List<String>  to= new ArrayList<String>();
     private List<String> cc= new ArrayList<String>();
     private List<String> bcc=new ArrayList<String>();
     private int templateNo;
     private HashMap<String ,String> parameters=new HashMap<String, String>();
     private HashMap<String, String> subjectParameters= new HashMap<String, String>();
     
     

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


	public int getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(int templateNo) {
		this.templateNo = templateNo;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

	public HashMap<String, String> getSubjectParameters() {
		return subjectParameters;
	}

	public void setSubjectParameters(HashMap<String, String> subjectParameters) {
		this.subjectParameters = subjectParameters;
	}
	
	
	
	
	

	
}
