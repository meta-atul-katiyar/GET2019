package com.metacube.springDemo.Service.Implimentation;

import com.metacube.springDemo.Service.IMailSender;

/*
 * Represent the Mock mail sender.
 */
public class MockMailSender implements IMailSender {

	@Override
	//Method to send mock type mail.
	public String sendMail() {
		return "Mock mail send";
	}

}