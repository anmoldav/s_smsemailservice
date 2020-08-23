package com.anmol.smsemailservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anmol.smsemailservice.entites.Template;

public interface TemplateRepository extends JpaRepository<Template, Integer> {
	
	

}
