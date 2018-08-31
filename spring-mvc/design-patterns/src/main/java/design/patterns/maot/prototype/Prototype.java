package design.patterns.maot.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import design.patterns.maot.demo.MailSender;
import design.patterns.maot.demo.Sender;

/**
 * 原型模式 深层复制，和浅复制
 * 
 * @author maot
 *
 */
public class Prototype implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private String a = "abc";
	private Sender sender = new MailSender();

	/**
	 * 浅复制,只复制基本数据类型
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Prototype proto = (Prototype) super.clone();
		return proto;
	}

	/**
	 * 深复制，复制基本数据类型和引用类型
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {

		/* 写入当前对象的二进制流 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		/* 读出二进制流产生的新对象 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object obj = ois.readObject();
		
		bos.close();
		oos.close();
		bis.close();
		ois.close();
		return obj;
	}

	public static void main(String[] args) throws Exception {
		Prototype proto = new Prototype();
		System.out.println(proto.a);
		System.out.println(proto.sender);

		Prototype protoClone = (Prototype) proto.clone();
		System.out.println(protoClone.a);
		System.out.println(protoClone.sender);

		Prototype protoDeepClone = (Prototype) proto.deepClone();
		System.out.println(protoDeepClone.a);
		System.out.println(protoDeepClone.sender);
	}
}
