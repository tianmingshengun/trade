package com.baseutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * redis工具类
 * 
 * @author admin
 *
 */
//@Component
public class RedisUtil {

	//@Autowired
	private StringRedisTemplate redisTemplate;// redis操作模板
	                          
	/**
	 * 添加
	 * 
	 * @param key
	 * @param vlaue
	 */
	public void put(String key, String value) {
		if (key != null && "".equals(key) == false) {
			redisTemplate.opsForHash().put(key, key, value);
			
		}
	}

	/**
	 * 添加
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		if (key != null && "".equals(key) == false) {
			redisTemplate.opsForHash().put(key, key, new Gson().toJson(value));
		}
	}

	/**
	 * 获取对象类型的value
	 * 
	 * @param key
	 * @param className
	 * @return
	 */
	public <T> T get(String key, Class<T> className) {
		Object obj = redisTemplate.opsForHash().get(key, key);
		if (obj != null) {
			return new Gson().fromJson(obj + "", className);
		} else {
			return null;
		}
	}
	/**
	 * 获取字符串类型的value
	 * @param key
	 * @return
	 */
   public String get(String key){
		Object obj = redisTemplate.opsForHash().get(key, key);
		if (obj != null) {
			return String.valueOf(obj);
		} else {
			return null;
		}
   }
   /**
    * 删除某个key的数据
    * @param key
    */
   public void delete(String key){
	   redisTemplate.opsForHash().delete(key, key);
   }
   /**
    * 判断键是否存在
    * @param key
    */
   public void isExist(String key){
	   redisTemplate.opsForHash().hasKey(key, key);
   }
}
