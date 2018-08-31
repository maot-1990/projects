package com.pers.util.reflect;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.pers.util.test.User;

public class ReflectUtils {

	/**
	 * 
	 * @param obj 对象
	 * @param flag 是否保存值为空的对象
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Map<String, Object> ObjectToMap(Object obj, boolean flag) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = obj.getClass().getDeclaredFields();
		if(fields != null && fields.length > 0){
			for(Field field : fields){
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		}
		
		return map;
	}
	
	/**
	 * map转化为对象
	 * @param <T>
	 * @param map
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static Object MapToObject(Map<String, Object> map, Class<? extends User> clazz) throws InstantiationException, IllegalAccessException{
		Object obj = clazz.newInstance();
		if(!map.isEmpty()){
			Field[] fields = obj.getClass().getDeclaredFields();
			if(fields != null && fields.length > 0){
				for(Field field : fields){
					field.setAccessible(true);
					field.set(obj, map.get(field.getName()));
				}
			}
		}
		
		
		return obj;
	}
}
