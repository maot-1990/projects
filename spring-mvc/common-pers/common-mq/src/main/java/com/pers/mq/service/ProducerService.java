package com.pers.mq.service;

import com.pers.mq.entity.MessageObject;

public interface ProducerService {
	
	public void sendMassageQueue(final MessageObject massage);
	
	public void sendMassageTopic(final MessageObject massage);
}
