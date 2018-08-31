package design.patterns.maot.factorymethod;

import design.patterns.maot.demo.MailSender;
import design.patterns.maot.demo.Sender;
import design.patterns.maot.demo.SmsSender;

/**
 * 工厂方法模式（Factory Method）
 * 总体来说，工厂模式适合：凡是出现了大量的对象需要创建，并且具有共同的接口时，
 * 可以通过工厂方法模式进行创建。在以上的三种模式中，第一种如果传入的字符串有误，
 * 不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，
 * 我们会选用第三种——静态工厂方法模式。
 * @author maot
 *
 */
public class SendFactory {
	
	/**
	 * 普通工厂模式
	 * @param type
	 * @return
	 */
	public static Sender getBean(String type){
		if("mail".equals(type)){
			return new MailSender();
		}else if("sms".equals(type)){
			return new SmsSender();
		}else{
			return null;
		}
	}
	
	/**
	 * 多个工厂方法模式
	 * @return
	 */
	public Sender produceMail1(){
		return new MailSender();
	}
	
	public Sender produceSms1(){
		return new SmsSender();
	}
	
	/**
	 * 静态工厂方法模式
	 * @return
	 */
	public static Sender produceMail2(){
		return new MailSender();
	}
	
	public static Sender produceSms2(){
		return new SmsSender();
	}

}
