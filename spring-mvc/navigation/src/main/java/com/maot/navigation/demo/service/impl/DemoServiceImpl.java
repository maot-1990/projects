package com.maot.navigation.demo.service.impl;

import org.springframework.stereotype.Service;

import com.maot.navigation.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public void testAspect(String name1, String name2) {
		System.out.println("testAspect:" + name1 + "," + name2);
		
	}
	
	@Override
	public void testAspect2(String name3, String name4, String name5) {
		System.out.println("testAspect:" + name3 + "," + name4 + "," + name5);
		
	}

}
