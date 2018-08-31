package com.pers.redis.service;

import java.util.Map;
import java.util.Set;

public interface RedisService {

	public void putForValue(String key, Object value);
	
	public Object getForValue(String key);
	
	public void putForHash(String key, Map<String, Object> map);
	
	public Object getForHash(String key);
	
	public void putForListRight(String key, Object value);
	
	public Object getForList(String key);
	
	public void putForSet(String key, Object... hashKeys);
	
	public Set<Object> getForSet(String key);
}
