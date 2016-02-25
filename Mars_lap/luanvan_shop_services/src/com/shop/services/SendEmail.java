package com.shop.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	public String sendmail(String subject, String msg,String addto) {
		String res="";
//		//Lib commons-email-1.4.jar
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(587);
//		email.setAuthenticator(new DefaultAuthenticator("lvshopper2016@gmail.com", "thanhnhan1"));
//		email.setSSLOnConnect(true);
//		email.setTLS(true);
//		try {
//			email.setFrom("lvshopper2016@gmail.com");
//			email.setSubject(subject);
//			email.setMsg(msg);
//			email.addTo(addto);
//			email.send();
//			
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("lvshopper2016@gmail.com", "thanhnhan1"));
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		email.setTLS(true);
		try {
			email.setFrom("lvshopper2016@gmail.com");
			email.setSubject(subject);
			email.setMsg(msg);
			email.addTo(addto);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
}
