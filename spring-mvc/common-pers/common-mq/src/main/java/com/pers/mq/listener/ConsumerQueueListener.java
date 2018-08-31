package com.pers.mq.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import com.pers.mq.entity.MessageObject;

public class ConsumerQueueListener implements MessageListener{

	public void onMessage(Message message) {
		 //这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换，或者直接把onMessage方法的参数改成Message的子类TextMessage  
		ObjectMessage objMsg = (ObjectMessage) message;   
        try {
        	System.out.println("收到Queue消息：消息内容：" + ((MessageObject)objMsg.getObject()).toString() + ",消息体："+ objMsg);   
           
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   

}
