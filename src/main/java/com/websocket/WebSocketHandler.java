package com.websocket;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 定义websocket请求处理器，处理文本数据信息
 * 
 * @author admin
 *
 */
public class WebSocketHandler extends TextWebSocketHandler {

	/**
	 * 连接成功之后，消息处理方式
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("恭喜你连接成功。。。。。");
		// 这个地方可以做一些准备性的工作

	}

	/**
	 * 关闭连接时触发
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

		System.out.println("连接已关闭。。。。");
		System.out.println(closeStatus.getReason());
	}

	/**
	 * 客户端信息处理方法
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		System.out.println("客户端发过来的消息：" + message.getPayload());
		//如果链路是开着的，我就给回一条
		if (session.isOpen() == true) {			   
			  session.sendMessage(new TextMessage("呦呦，切克闹啊。。。"));
		}

	}

	/**
	 * 链接出错时的处理方法
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}

	}

	/**
	 * 给某个用户发送消息
	 *
	 * @param userName
	 * @param message
	 */
	/*
	 * public void sendMessageToUser(String userName, TextMessage message) { for
	 * (WebSocketSession user : users) { if
	 * (user.getAttributes().get("WEBSOCKET_USERNAME").equals(userName)) { try {
	 * if (user.isOpen()) { user.sendMessage(message); } } catch (IOException e)
	 * { e.printStackTrace(); } break; } } }
	 * 
	 *//**
		 * 给所有在线用户发送消息
		 *
		 * @param message
		 *//*
		 * public void sendMessageToUsers(TextMessage message) { for
		 * (WebSocketSession user : users) { try { if (user.isOpen()) {
		 * user.sendMessage(message); } } catch (IOException e) {
		 * e.printStackTrace(); } } }
		 */
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
}
