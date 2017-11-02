package com.baseutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 调用外部接口工具类
 * @author admin
 *
 */
public class HttpClientUtil {
	// 建立默认的http客户端
		private static CloseableHttpClient httpclient = HttpClients.createDefault();

		/**
		 * 发送post请求
		 * 
		 * @param url
		 * @return
		 */
		public static String post(String url, Map map) {
			// 建立请求方式
			HttpPost post = new HttpPost(url);
			// 响应流
			CloseableHttpResponse postResponse = null;
			// 设置参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// 获取map的键值集合
			Set set = map.keySet();
			for (Object key : set) {
				params.add(new BasicNameValuePair(key.toString(), map.get(key).toString()));
			}
			try {
				
				post.setEntity(new UrlEncodedFormEntity(params,Consts.UTF_8));
				postResponse = httpclient.execute(post);
				if (postResponse != null) {
					HttpEntity entity = postResponse.getEntity();			
					System.out.println("发送请求之后返回的状态" + postResponse.getStatusLine());			
					String result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("发送请求后返回的内容"+result);
					EntityUtils.consume(entity);
					postResponse.close();
					return result;
				}

			} catch (Exception e) {
				System.out.println("哈哈出错了。。。。。。。。。。。。。。。。");
				e.printStackTrace();
			}

			return "error";
		}
		/**
		 * 发送get请求
		 * @return
		 */
		public static String  get(String url,Map map){		
			
			if(map!=null){
				//分离参数，建立完整的url
				Set set=map.keySet();
				url+="?";
				for (Object key : set) {
			    	url+=key+"="+map.get(key).toString()+"&";
				}
			}
			
			//建立请求方式
			HttpGet get=new HttpGet(url);
			
			// 响应流
		     CloseableHttpResponse getResponse = null;
			try {
				getResponse=httpclient.execute(get);
				if(getResponse !=null){
				HttpEntity entity=getResponse.getEntity();
				
				System.out.println("发送请求之后的响应状态"+getResponse.getStatusLine());
				String result =EntityUtils.toString(entity, "UTF-8");
				System.out.println("返回的内容"+result);			
				EntityUtils.consume(entity);
				getResponse.close();
				return result;
				}
			} catch (Exception e) {
				System.out.println("哈哈出错了。。。。。。。。。。。。。。。。");
				e.printStackTrace();
			}
			
			return "error";
		}
		/**
		 * 发送无参数名称的post请求
		 * 
		 * @param url
		 * @return
		 */
		public static String post(String url,String access_token ,String body) {
			//组建新的url
			String newUrl=url.replaceAll("Access_token", access_token);
			// 建立请求方式
			HttpPost post = new HttpPost(newUrl);
			
			// 响应流
			CloseableHttpResponse postResponse = null;
			try {  
				
				StringEntity bodyEntity = new StringEntity(body,"UTF-8");
				post.setEntity(bodyEntity);
				
				postResponse = httpclient.execute(post);
				if (postResponse != null) {
					HttpEntity entity = postResponse.getEntity();			
					System.out.println("发送请求之后返回的状态" + postResponse.getStatusLine());			
					String result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("发送请求后返回的内容"+result);
					EntityUtils.consume(entity);
					postResponse.close();
					return result;
				}

			} catch (Exception e) {
				System.out.println("哈哈出错了。。。。。。。。。。。。。。。。");
				e.printStackTrace();
			}

			return "error";
		}
		/**
		 * 利用post请求上传文件，模仿curl
		 * 
		 * @param url
		 * @return
		 */
		public static String post(String url,String access_token,File file) {
			//组建新的url
			String newUrl=url.replaceAll("Access_token", access_token);
			
			if(!file.exists()){
			   return "文件不存在";	
			}
			// 建立请求方式
			HttpPost post = new HttpPost(newUrl);
			
			// 响应流
			CloseableHttpResponse postResponse = null;
			try {  
				//开始封装文件
				FileBody bodyEntity=new FileBody(file);
				HttpEntity reqEntity = MultipartEntityBuilder.create()
	                    .addPart("bodyEntity", bodyEntity)
	                    .build();
				post.setEntity(reqEntity);
				
				postResponse = httpclient.execute(post);
				if (postResponse != null) {
					HttpEntity entity = postResponse.getEntity();			
					System.out.println("发送请求之后返回的状态" + postResponse.getStatusLine());			
					String result = EntityUtils.toString(entity, "UTF-8");
					System.out.println("发送请求后返回的内容"+result);
					EntityUtils.consume(entity);
					postResponse.close();
					return result;
				}

			} catch (Exception e) {
				System.out.println("哈哈出错了。。。。。。。。。。。。。。。。");
				e.printStackTrace();
			}

			return "error";
		}
		
}
