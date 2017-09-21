package com.webservice.impl;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.webservice.MyWebService;
/**
 * webservice实现类
 * @author admin
 *
 */
@WebService(name="me",portName="meport")
public class MyWebServiceImpl implements MyWebService {
    
	@WebMethod
	public String say() {
		
		return "Hello World";
	}
	
	public static void main(String[] args) {
		String url="http://127.0.0.1/ws";
		Endpoint.publish(url,new MyWebServiceImpl());
		System.out.println("哈哈，我发布l");
		
	}


}
