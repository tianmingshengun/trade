package com.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
/**
 * 定义websocket配置类，注册websocket处理类
 */
@Configuration //配置spring容器上下文，相当于beans的命名空间
@EnableWebMvc
@EnableWebSocket
@ComponentScan(basePackageClasses = { SpringWebsocketConfigurer.class })
public class SpringWebsocketConfigurer extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		//为指定请求添加处理类及拦截器
		registry.addHandler(webSocketHandler(),"/websocket/socketServer.do").
		addInterceptors(new SpringWebSocketHandlerInterceptor());
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }
 
    @Bean  //定义bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHandler();
    }
    
}


