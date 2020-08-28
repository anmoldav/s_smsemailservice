package com.anmol.smsemailservice.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_template")
public class Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "template_no")
	private int templateNo;
	@Column(name = "subject")
	private String tempSubject;
	@Column(name = "body")
	private String tempBody;

	public int getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(int templateNo) {
		this.templateNo = templateNo;
	}

	public String getTempSubject() {
		return tempSubject;
	}

	public void setTempSubject(String tempSubject) {
		this.tempSubject = tempSubject;
	}

	public String getTempBody() {
		return tempBody;
	}

	public void setTempBody(String tempBody) {
		this.tempBody = tempBody;
	}

	@Override
	public String toString() {
		return "Template [templateNo=" + templateNo + ", tempSubject=" + tempSubject + ", tempBody=" + tempBody + "]";
	}

}
