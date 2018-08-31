package design.patterns.maot.abstractfactory;

import design.patterns.maot.demo.MailSender;
import design.patterns.maot.demo.Sender;

public class MailSenderFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}

	
}
