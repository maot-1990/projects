package com.pers.mq.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.pers.mq.entity.MessageObject;
import com.pers.mq.service.ProducerService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService{
	
	@Resource
	private JmsTemplate jmsTemplate; 
	
	@Autowired
	@Qualifier("queueDestination")
	private Destination destination_queue;;
	
	@Autowired
	@Qualifier("topicDestination")
	private Destination destination_topic;;
	
	public void sendMassageQueue(final MessageObject massage){
		jmsTemplate.send(destination_queue, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				try {
					ObjectMessage object = session.createObjectMessage();
					object.setObject(massage);
					return object;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				
			}
		});
	}
	
	public void sendMassageTopic(final MessageObject massage){
		jmsTemplate.send(destination_topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				try {
					ObjectMessage objMsg = session.createObjectMessage();
					objMsg.setObject(massage);
					return objMsg;
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}
}
