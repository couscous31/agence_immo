package fr.adaming.service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import fr.adaming.model.Visite;


@Service
public class EnvoyerMail implements IEnvoyerMail {
	
	
	public  void envoyerMessageAjout(String mailRecup,Visite vi) {
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
         message.setContent("Bonjour nous confirmons que votre visite aura lieu le "+vi.getDatevisite()+ "à" +vi.getHeure()+ "A bientot!", "text/html");

         // Send message
         Transport.send(message, message.getAllRecipients());
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
}

	
}
