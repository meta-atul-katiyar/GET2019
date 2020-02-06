package com.metacube.springDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.springDemo.Service.IMailSender;

/**
* It is a controller class. 
*It have different-2 type of annotation for call config class. 
**/
//@Controller
//@ResponseBody
@RestController
public class AppController {
	 private IMailSender mail;
	 
//	 /*setter injection */
//	 @Autowired
//	 public void setMail(IMailSender mail) {
//			this.mail = mail;
//	  }
	
	 /*Constructor injection with @Primary Annotation */
	 @Autowired
	 public AppController(IMailSender mail) {
		this.mail = mail;
	  }
	
//	 /*Dependency injection by name*/ 
//	 @Autowired
//	 public AppController(IMailSender mockMailSender) {
//		this.mail = mockMailSender;
//	  }
	  
//	 /*Dependency injection by name*/
//	 @Autowired
//	 public AppController(IMailSender smtpMailSender) {
//		this.mail = smtpMailSender;
//	  }
	 
//	 /*Bean qualifiers */
//	 @Autowired
//	 public AppController(@Qualifier("smtpMailSender")IMailSender mail) {
//		this.mail = mail;
//	  }
	 
//	 /*Bean qualifiers */
//	 @Autowired
//	 public AppController(@Qualifier("mockMailSender")IMailSender mail) {
//		this.mail = mail;
//	  }
	 
	 /*using config class with @Primary Annotation   */
//	 @Autowired
//	 public AppController(IMailSender mail) {
//		this.mail = mail;
//	  }
	 
	 @RequestMapping("/mail")
	 public String name() { 
		return mail.sendMail();
	}
}