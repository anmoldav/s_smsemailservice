package com.anmol.smsemailservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anmol.smsemailservice.entites.EmailDelivary;

public interface EmailDelivaryRepository extends JpaRepository<EmailDelivary,Integer>{
	

}
