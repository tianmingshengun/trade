package com.baseutil;

import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * redis拦截器，用于适时加载缓存数据
 * @author admin
 *
 */
public class RedisInterceptor implements MethodInterceptor {
 
	//@Autowired
	private RedisUtil redisCacheUtil;
	
	private List<String> serviceList;  //不拦截的service列表
	private List<String> methodList;//不拦截的方法名称列表
		
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object value=null;
		
		//获取拦截的类名及方法名
		String serviceName=invocation.getThis().getClass().getName();
		String methodName=invocation.getMethod().getName();
		
		if(serviceList.contains(serviceName)){
			
		}
		
		
		
		return value;
	}
	/**
	 * 是否加入缓存
	 * @param serviceName
	 * @param methodName
	 * @return
	 */
	private boolean isAddCache(String serviceName,String methodName){
		    boolean flag=true;
		    if(serviceList.contains(serviceName) || methodList.contains(methodName)){
		    	flag=false;
		    }
		    return flag;
	}
	/**
	 * 创建缓存key,保持数据查询的一致性
	 * @param serviceName
	 * @param methodName
	 * @param arguments
	 * @return
	 */
	private String getCacheKey(String serviceName,String methodName,Object[] arguments){
		    StringBuffer sb=new StringBuffer();
		    sb.append(serviceName).append("_").append(methodName);
		    if((arguments !=null) && (arguments.length !=0)){
		    	for(int i=0;i<arguments.length;i++){
		    		sb.append("_").append(arguments[i]);
		    	}
		    }
		    return sb.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
