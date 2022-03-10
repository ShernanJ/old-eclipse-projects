package ca.sheridancollege.javiersh.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void sendEmail (String to, String subject, String text) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		System.out.println("Sending the email....");
		
		// Specify the details
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text);
		
		try {
			// Attempt sending the email
			javaMailSender.send(msg);
		}catch(Exception ex) {
			
			// Print stack trace in case something goes wrong
			ex.printStackTrace();
		}
		
		System.out.println("The email was successfully sent :-)");
		
	}
	
	
}
