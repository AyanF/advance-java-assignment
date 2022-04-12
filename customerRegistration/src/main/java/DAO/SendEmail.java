package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DTO.UserLogin;

public class SendEmail {
	//generate verification code
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	//send email to the user email
	public boolean sendEmail(UserLogin user) {
		boolean test = false;

		String toEmail = user.getUserLoginId();

		//		  String fromEmail = ""; String password =
		//		  "";


		try {

			Properties propCred = new Properties();
			propCred.load(new FileInputStream("/home/ayan/eclipse-workspace/customerRegistration/data.properties"));
			String fromEmail = propCred.getProperty("username");
			String password = propCred.getProperty("password");

			// your host email smtpserver details
			Properties pr = new Properties();
			pr.setProperty("mail.smtp.host", "smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "465");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.ssl.enable", "true");

			/*
			 * pr.put("mail.smtp.socketFactory.port", "25");
			 * pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			 */


			//get session to authenticate the host email address and password
			Session session = Session.getInstance(pr, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			});

			//set email message details
			Message mess = new MimeMessage(session);

			//set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			//set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			//set email subject
			mess.setSubject("User Email Verification");

			//set message text
			mess.setText("Registered successfully.Please verify your account using this code: " + user.getCode());
			//send the message
			Transport.send(mess);

			test=true;

		} catch (FileNotFoundException fnE) {
			fnE.printStackTrace();
		}
		catch (IOException ioE) {
			ioE.printStackTrace();
		}
		catch (MessagingException msgE) {
			msgE.printStackTrace();
		}

		return test;
	}

}

