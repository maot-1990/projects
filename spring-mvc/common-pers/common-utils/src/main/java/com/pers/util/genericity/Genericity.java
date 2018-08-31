package com.pers.util.genericity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.pers.util.test.User;

public class Genericity<T> {

	private T obj;
	
	public Genericity(T t){
		this.obj = t;
	}

	public Genericity<?> getType(T name){
		Genericity<?> g = new Genericity<T>(name);
		
		return g;
	}
	
	@Override
	public String toString() {
		return "Genericity [obj=" + obj + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public static void getClassName(Class<? extends User> clazz) throws Exception{
		Object obj = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		Field[] fields = clazz.getDeclaredFields();
		if(methods != null && methods.length > 0){
			for(Method m : methods){
				if("setName".equals(m.getName())){
					m.invoke(obj, "test");
				}
				
			}
		}
		for(Field field : fields){
			if("String".equals(field.getType().getSimpleName())){
				field.setAccessible(true);
				System.out.println(field.getName() + "," + field.get(obj));
			}
			if("Date".equals(field.getType().getSimpleName())){
				field.setAccessible(true);
				System.out.println(field.getName() + "," + field.get(obj));
			}
			
			if(Class.forName(field.getType().getName()).newInstance() instanceof String){
				System.out.println("合适");
			}
			
		}
		
		
		System.out.println(obj.getClass().getName());
	}
	
	public static void main(String[] args) {
		/*Genericity<String> g = new Genericity<String>("123");
		System.out.println(g.toString());*/
		try {
			getClassName(User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
