package com.maot.navigation.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maot.navigation.demo.service.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/test",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> test(@RequestParam(required=false,value="String") String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String maot = null;
		System.out.println(maot.toString());
		map.put("test", "true");
		return map;
	}
	
	@RequestMapping(value="/test1",method={RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> test1(String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		String maot = null;
		map.put("test", "true");
		map.put("msg", value);
		return map;
	}
	
	@RequestMapping(value="/testAspect",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> testAspect(@RequestParam(required=false,value="String") String value) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		demoService.testAspect("m","t");
		demoService.testAspect2("a","a", "rt");
		map.put("test", "true");
		return map;
	}

}
