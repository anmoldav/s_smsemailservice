package com.anmol.smsemailservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.anmol.smsemailservice.reqresp.MailRequest;
import com.anmol.smsemailservice.utils.EmailUtility;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub]
		MailRequest request = new MailRequest();
		List<String> to = new ArrayList<String>();
		to.add("kshirsagarvikram7@gmail.com");
		request.setTo(to );
		request.setFrom("anmoldavane@gmail.com");
		request.setSubject("Subject");
		EmailUtility utility=new EmailUtility();
		try {
			utility.sendmail(request);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
