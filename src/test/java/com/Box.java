package com;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Box<T> {

	private T data;
	private  Class<T> returnType;
	
	public Box() {
         Class c=this.getClass();
         Type t=c.getGenericSuperclass();
         if(t instanceof ParameterizedType){
        	Type param[] =((ParameterizedType) t).getActualTypeArguments();
        	this.returnType=(Class<T>)param[0];
        	System.out.println(returnType);
         }
        
	}

	public Box(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public  Class<T> getReturnType() {
		return returnType;
	}

	public void setReturnType(Class<T> returnType) {
		this.returnType = returnType;
	}

}
