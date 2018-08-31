/*package com.maot.test.mq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.mq.entity.MessageObject;
import com.pers.mq.service.ProducerService;

@Controller
@RequestMapping("/mq")
public class ActivityMqController {
	
	@Resource
	private ProducerService producerService;

	@RequestMapping("/sendQ")
	@ResponseBody
	public Map<String, Object> sendQ(String message){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MessageObject msg = new MessageObject();
		msg.setObj(message);
		producerService.sendMassageQueue(msg);
		return resultMap;
	}
	
	@RequestMapping("/sendT")
	@ResponseBody
	public Map<String, Object> sendT(String message){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		MessageObject msg = new MessageObject();
		msg.setObj(message);
		producerService.sendMassageTopic(msg);
		return resultMap;
	}
}
*/