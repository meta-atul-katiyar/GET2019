package com.metacube.springDemo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.metacube.springDemo.Service.IMailSender;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

	  @Autowired
		private IMailSender mail;
		
		@Test
		@Ignore
		public void springEqualTest() {
			 String returnString = mail.sendMail();
			 Assert.assertEquals("Mock mail send", returnString);
		}
		
		@Test
		public void springNotEqualTest(){
			 String returnString = mail.sendMail(); 
			 Assert.assertNotEquals("Smtp mail send", returnString);
		}
}
