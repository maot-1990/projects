package com.pers.util.genericity;

public class Test {

	public <T> void  test(T t){
	}
	
	public static void main(String[] args) throws ClassNotFoundException {  
        String str=get("Hello", "World");  
        System.out.println(str);  
    }  
  
    public static <T, U> T get(T t, U u) {  
        if (u != null)  
            return t;  
        else  
            return null;  
    }  
}
