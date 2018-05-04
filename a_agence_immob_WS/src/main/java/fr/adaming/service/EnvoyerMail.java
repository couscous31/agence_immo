package fr.adaming.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
public class EnvoyerMail implements IEnvoyerMail {
	
	
	public  void envoyerMessageAjout(String mailRecup) {
	final String username = "wyndy.foy@gmail.com";
	final String password = "260588WC";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	
	// Get Session object.
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
	try {

		// Create a default MimeMessage object.
		Message message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress("wyndy.foy@gmail.com"));

		// Set To: header field of the header.
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailRecup));

		// Set Subject: header field
		message.setSubject("Nouvelle visite");
		
		

         // Send the actual HTML message, as big as you like
         message.setContent("<h1>F�licitations ! Vous avez bien �t� int�gr� � notre base de donn�es.</h1>", "text/html");

         // Send message
         Transport.send(message, message.getAllRecipients());
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
}

	
}
