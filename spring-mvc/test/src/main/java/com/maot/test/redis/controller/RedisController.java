/*package com.maot.test.redis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pers.redis.service.RedisService;


@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Resource
	private RedisService redisService;

	@RequestMapping("/saveMsg")
	@ResponseBody
	public Map<String, Object> saveMsg(String value){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		redisService.putForValue("key1", value);
		System.out.println("ForValue:" + redisService.getForValue("key1"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key2", value);
		redisService.putForHash("key2", map);
		System.out.println("ForHash:" + redisService.getForHash("key2"));
		
		List list = new ArrayList();
		list.add(value);
		list.add(value);
		list.add(value);
		redisService.putForListRight("key5", list);
		System.out.println("ForList:" + redisService.getForList("key5"));
		
		redisService.putForSet("key4", value, value, value);
		System.out.println("ForSet:" + redisService.getForSet("key4"));
		
		resultMap.put("code", "200");
		resultMap.put("msg", "成功");
		return resultMap;
	}
}
*/