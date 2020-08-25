package com.anmol.smsemailservice.utils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anmol.smsemailservice.entites.EmailDelivary;
import com.anmol.smsemailservice.repo.EmailDelivaryRepository;
import com.anmol.smsemailservice.reqresp.MailRequest;

@Component
public class EmailUtility {
	Logger logger= LoggerFactory.getLogger(EmailUtility.class);

	@Autowired
	private EmailDelivaryRepository emailDelivaryRepository;

	public void sendmail(MailRequest mailRequest, String tempBody, String tempsubject)
			throws AddressException, MessagingException, IOException {
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

		List<String> recipientList = mailRequest.getTo();

//      InternetAddress[] addresses = new InternetAddress[mailRequest.getTo().size()];
		InternetAddress[] recipientAddress = new InternetAddress[recipientList.size()];
		int counter = 0;
		for (String recipient : recipientList) {
			recipientAddress[counter] = new InternetAddress(recipient.trim());
			counter++;
		}
		msg.setFrom(new InternetAddress(mailRequest.getFrom(), false));
		msg.setRecipients(Message.RecipientType.TO, recipientAddress);

		List<String> ccrecipientList = mailRequest.getCc();
		InternetAddress[] ccrecipientAddress = new InternetAddress[ccrecipientList.size()];
		int count = 0;
		for (String ccrecipient : ccrecipientList) {
			ccrecipientAddress[count] = new InternetAddress(ccrecipient.trim());
			count++;
		}
		msg.setRecipients(Message.RecipientType.CC, ccrecipientAddress);

		List<String> bccrecipientList = mailRequest.getBcc();
		InternetAddress[] bccRecipientAddress = new InternetAddress[bccrecipientList.size()];
		int count1 = 0;
		for (String bccRecipient : bccrecipientList) {
			bccRecipientAddress[count1] = new InternetAddress(bccRecipient.trim());
			count1++;
		}
		msg.setRecipients(Message.RecipientType.BCC, bccRecipientAddress);

		msg.setSubject(tempsubject);

		msg.setContent(tempBody, "text/html");

		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(tempBody, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		// MimeBodyPart attachPart = new MimeBodyPart();

		// attachPart.attachFile("/var/tmp/image19.png");
		// multipart.addBodyPart(attachPart);
		msg.setContent(multipart);

		EmailDelivary delivary = new EmailDelivary();
		try {

			delivary.setTo(mailRequest.getTo().toString());
			if (mailRequest.getCc() != null && !mailRequest.getCc().isEmpty())
				delivary.setCc(mailRequest.getCc().toString());

			if (mailRequest.getBcc() != null && !mailRequest.getBcc().isEmpty())
				delivary.setBcc(mailRequest.getBcc().toString());

			delivary.setSubject(tempsubject);
			delivary.setBody(tempBody);

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			delivary.setCreatedTimeStamp(timestamp);

			Transport.send(msg);
			delivary.setStatus("SENT");
		} catch (Exception e) {
			logger.error(e.getMessage());
			//System.out.println(e.getMessage());
			delivary.setStatus(e.getMessage());
		} finally {
			EmailDelivary save = emailDelivaryRepository.save(delivary);
			System.out.println("save-->" + save.getId());
		}
	}

}
