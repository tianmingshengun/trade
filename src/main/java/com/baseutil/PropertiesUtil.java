package com.baseutil;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * 配置文件工具类
 * @author admin
 *
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer{
  
	private static Map<String, String> propsMap; //用于封装属性及其相关联的值
	
	/**
	 * 将传入的properties文件封装成java properties实例
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		    super.processProperties(beanFactoryToProcess, props);
		    propsMap=new HashMap<String,String>();
		    
		    for (Object key : props.keySet()) {
				 String keyStr=key.toString();
				 String value=props.getProperty(keyStr);
				 propsMap.put(keyStr, value);
			}
	}
    
	/**
	 * 通过键获取属性值
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		return propsMap.get(key);
	}
	/**
	 * 获取属性,值的map集合
	 * @return
	 */
	public static Map<String, String> getPropsMap(){
		return propsMap;
	}
}
