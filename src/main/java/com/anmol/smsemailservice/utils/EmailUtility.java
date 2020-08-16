package com.anmol.smsemailservice.utils;

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

import org.springframework.stereotype.Component;

import com.anmol.smsemailservice.reqresp.MailRequest;
@Component
public class EmailUtility {

	
	public void sendmail(MailRequest mailRequest) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("anmoldavane@gmail.com", "8856074987");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress(mailRequest.getFrom(), false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailRequest.getTo()));
		   msg.setSubject(mailRequest.getSubject());
		   msg.setContent(mailRequest.getBody(), "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent(mailRequest.getBody(), "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		  // MimeBodyPart attachPart = new MimeBodyPart();

		   //attachPart.attachFile("/var/tmp/image19.png");
		   //multipart.addBodyPart(attachPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
	
	
	
}
