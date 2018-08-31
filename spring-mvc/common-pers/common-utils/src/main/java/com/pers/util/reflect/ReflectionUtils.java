package com.pers.util.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils {

    public static Map<String, Object> objToMap(Object obj) throws Exception{
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if(obj != null){
            Field[] fields = obj.getClass().getDeclaredFields();
            Field[] supperFields = obj.getClass().getSuperclass().getDeclaredFields();
            if(fields != null && fields.length > 0){
                for(Field field : fields){
                    field.setAccessible(true);
                    boolean isIgnore = false;
                    Annotation[] annotations = field.getAnnotations();
                    if(annotations != null && annotations.length > 0){
                        for(Annotation annotation : annotations){
                            if("Ignore".equals(annotation.annotationType().getSimpleName())){
                                isIgnore=true;
                            }
                        }
                    }
                    if(!isIgnore){
                        resultMap.put(field.getName(), field.get(obj));
                    }
                }
            }
            if(supperFields != null && supperFields.length > 0){
                for(Field field : supperFields){
                    field.setAccessible(true);
                    boolean isIgnore = false;
                    Annotation[] annotations = field.getAnnotations();
                    if(annotations != null && annotations.length > 0){
                        for(Annotation annotation : annotations){
                            if("Ignore".equals(annotation.annotationType().getSimpleName())){
                                isIgnore=true;
                            }
                        }
                    }
                    if(!isIgnore){
                        resultMap.put(field.getName(), field.get(obj));
                    }
                }
            }
        }
        return resultMap;
    }

    public static Object mapToObj(Map<String, Object> map, Class clazz) throws Exception{
        Object obj = clazz.newInstance();
        if(map != null && map.size() > 0){
            for(Map.Entry<String, Object> entry : map.entrySet()){
                String key = entry.getKey();
                Object value = entry.getValue();
                Method method = clazz.getMethod("set" + key.substring(0, 1).toUpperCase() +
                        key.substring(1, key.length()), value.getClass());
                method.invoke(obj, value);
            }
        }
        return obj;
    }
}
