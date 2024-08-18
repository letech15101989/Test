package com.nojata.UserAuthentication;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthenticationApplication.class, args);
//                  // Sender's email address
//        String senderEmail = "your-email@gmail.com";
//        // Recipient's email address
//        String recipientEmail = "recipient-email@example.com";
//        // Your app password
//        String appPassword = "your-app-password";
//
//        // Set mail properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "587");
//
//        // Create a session with authentication
//            Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, appPassword);
//            }
//        });
//
//        try {
//            // Create a MimeMessage object
//            MimeMessage message = new MimeMessage(session);
//            // Set From: header field
//            message.setFrom(new InternetAddress(senderEmail));
//            // Set To: header field
//            message.addRecipient(message.RecipientType.TO, new InternetAddress(recipientEmail));
//            // Set Subject: header field
//            message.setSubject("Test Email");
//            // Set the actual message
//            message.setText("This is a test email sent from Java using the Gmail SMTP server.");
//
//            // Send the message
//            Transport.send(message);
//            System.out.println("Email sent successfully!");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//	}
        }
        
}
