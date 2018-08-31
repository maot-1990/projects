package design.patterns.maot.abstractfactory;

import design.patterns.maot.demo.Sender;

public class Test {

	public static void main(String[] args) {
		Provider provider = new MailSenderFactory();
		Sender send = provider.produce();
		send.send();
	}

}
