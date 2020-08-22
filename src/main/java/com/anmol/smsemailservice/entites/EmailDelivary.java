package com.anmol.smsemailservice.entites;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_email_delivary", schema = "email_schema")
public class EmailDelivary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "_to")
	//private List<String> to= new ArrayList<String>();
	private String to;
	private String cc;
	//private List<String>cc= new ArrayList<String>();
	
	private String bcc;
	//private List<String> bcc= new ArrayList<String>();
	private String subject;
	private String body;
	private String status;
	@Column(name="created_timestamp")
	private Timestamp createdTimeStamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp timestamp) {
		this.createdTimeStamp = timestamp;
	}

	@Override
	public String toString() {
		return "EmailDelivary [id=" + id + ", to=" + to + ", cc=" + cc + ", bcc=" + bcc + ", subject=" + subject
				+ ", body=" + body + ", status=" + status + ", createdTimeStamp=" + createdTimeStamp + "]";
	}



	
	
	
}
