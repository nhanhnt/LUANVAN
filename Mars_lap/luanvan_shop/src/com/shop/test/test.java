package com.shop.test;

import org.apache.axis2.AxisFault;

import com.shop.services.SendEmailStub;
import com.shop.services.SendEmailStub.Sendmail;
import com.shop.services.SendEmailStub.SendmailResponse;

import java.rmi.RemoteException;

public class test {

	public static void main(String[] args) throws RemoteException {
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.googlemail.com");
//		email.setSmtpPort(587);
//		email.setAuthenticator(new DefaultAuthenticator("lvshopper2016@gmail.com", "thanhnhan1"));
//		email.setSSLOnConnect(true);
//		email.setStartTLSEnabled(true);
//		email.setTLS(true);
//		try {
//			email.setFrom("lvshopper2016@gmail.com");
//			email.setSubject("TestMail");
//			email.setMsg("This is a test mail ... :-) Test mail thôi");
//			email.addTo("lvshopper2016@gmail.com");
//			email.send();
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		SendEmailStub sendstub;
		try {
			sendstub = new SendEmailStub();
			Sendmail sen=new Sendmail();
			sen.setSubject("Test mail");
			sen.setMsg("Nội dung test mail mới nhất3333");
			sen.setAddto("lvshopper2016@gmail.com");
			SendmailResponse res=sendstub.sendmail(sen);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		final String username = "lvshopper2016@gmail.com";
//		final String password = "thanhnhan1";
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("lvshopper2016@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("lvshopper2016@gmail.com"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
//
//			Transport.send(message);
//
//			System.out.println("Done");
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
		
		
		
		
	}

}
