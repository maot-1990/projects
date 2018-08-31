package com.pers.util.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pers.util.reflect.ReflectUtils;

public class Test {

	public static void main(String[] args) throws Exception{
		/*User user = new User();
		user.setId("1234");
		user.setName("maot");
		user.setPwd("123456");
		//user.setSex("boy");
		user.setAddress("");
		user.setCreateTime(new Date());
		System.out.println(ReflectUtils.ObjectToMap(user, true));
	
		Annotation[] a = user.getClass().getDeclaredAnnotations();
		for(int i=0; i<a.length; i++){
			Annotation anno = a[i];
			com.pers.util.annotation.Test test = (com.pers.util.annotation.Test) anno;
			System.out.println(test.value());
			com.pers.util.enums.Test[] testEnums = test.name();
			System.out.println(testEnums[0]);
		}*/
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1234");
		map.put("name", "maot");
		map.put("pwd", "123456");
		map.put("sex", "boy");
		map.put("qwer", "asdf");
		map.put("createTime", new Date());
		System.out.println(ReflectUtils.MapToObject(map, User.class));
	
	}
}
