package com.metacube.springDemo.Service.Implimentation;

import com.metacube.springDemo.Service.IMailSender;

/**
 *Represent the smtp mail sender. 
 */
public class SmtpMailSender implements IMailSender {

	@Override
	//Method to send smtp type mail.
	public String sendMail() {
		return "Smtp Mail send";
	}

}