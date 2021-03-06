package service.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import service.face.AdminMailService;
import util.mail.MailAuth;

public class AdminMailServiceImpl implements AdminMailService {
	
	@Override
	public void sendMail(List<String> mailList, String mailTitle, String mailContent) {
		 
		Properties p = new Properties();
		
		p.put("mail.smtp.user","gonggongyeonhee@gmail.com");
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		try {
			Authenticator auth = new MailAuth();
			Session session = Session.getInstance(p, auth);
			session.setDebug(true); 

			MimeMessage msg = new MimeMessage(session);
			String message = mailContent;
			msg.setSubject(mailTitle);

			Address fromAddr = new InternetAddress("gonggongyeonhee@gmail.com"); 
			msg.setFrom(fromAddr);
			
//			Address toAddr = new InternetAddress(memMail); 
			
			InternetAddress[] addArray = new InternetAddress[mailList.size()];
			for(int i=0; i<mailList.size(); i++) {
				addArray[i] = new InternetAddress((String) mailList.get(i));
			}
			
			msg.addRecipients(Message.RecipientType.BCC, addArray);
			msg.setContent(message, "text/html; charset=EUC-KR");

			Transport.send(msg);

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void sendMail(String mailForPw, String mailTitle, String mailContent) {
		 
		Properties p = new Properties();
		
		p.put("mail.smtp.user","gonggongyeonhee@gmail.com");
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		try {
			Authenticator auth = new MailAuth();
			Session session = Session.getInstance(p, auth);
			session.setDebug(true); 

			MimeMessage msg = new MimeMessage(session);
			String message = mailContent;
			msg.setSubject(mailTitle);

			Address fromAddr = new InternetAddress("gonggongyeonhee@gmail.com"); 
			msg.setFrom(fromAddr);
			
			Address toAddr = new InternetAddress(mailForPw); 
			
//			InternetAddress[] addArray = new InternetAddress[mailList.size()];
//			for(int i=0; i<mailList.size(); i++) {
//				addArray[i] = new InternetAddress((String) mailList.get(i));
//			}
			
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(message, "text/html; charset=EUC-KR");

			Transport.send(msg);

		} catch (Exception e) { 
			e.printStackTrace();
		}
		
	}
	

}
