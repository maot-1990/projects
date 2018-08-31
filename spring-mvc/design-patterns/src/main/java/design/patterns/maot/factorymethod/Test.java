package design.patterns.maot.factorymethod;

import design.patterns.maot.demo.MailSender;
import design.patterns.maot.demo.Sender;
import design.patterns.maot.demo.SmsSender;

public class Test {

	public static void main(String[] args) {
		Sender send1 = new MailSender();
		send1.send();
		Sender send2 = new SmsSender();
		send2.send();
		
		Sender send3 = SendFactory.getBean("sms");
		send3.send();

		Sender send4 = SendFactory.produceMail2();
		send4.send();
		
	}

}
