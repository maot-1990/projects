package com.pers.redis.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.pers.redis.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 对String数据类型的操作
	 * @param key
	 * @param value
	 * @return
	 */
	public void putForValue(String key, Object value){
		redisTemplate.opsForValue().set(key, value);
	}
	
	public Object getForValue(String key){
		return redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 对哈希数据类型的操作
	 * @param key
	 * @param value
	 * @return
	 */
	public void putForHash(String key, Map<String, Object> map){
		redisTemplate.opsForHash().putAll(key, map);
	}
	
	public Object getForHash(String key){
		return redisTemplate.opsForHash().entries(key);
	}
	
	/**
	 * 对列表数据类型的操作
	 * @param key
	 * @param value
	 * @return
	 */
	public void putForListRight(String key, Object value){
		redisTemplate.opsForList().rightPush(key, value);
	}
	
	public Object getForList(String key){
		return redisTemplate.opsForList().rightPop(key);
	}
	
	/**
	 * 对集合数据类型的操作
	 * @param key
	 * @param hashKey
	 * @param value
	 * @return
	 */
	public void putForSet(String key, Object... values){
		redisTemplate.opsForSet().add(key, values);
	}
	
	public Set<Object> getForSet(String key){
		return redisTemplate.opsForSet().members(key);
	}
}
