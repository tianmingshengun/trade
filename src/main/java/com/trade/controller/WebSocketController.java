package com.trade.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.websocket.WebSocketHandler;

/**
 * websocket控制器
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/WebSocketController")
public class WebSocketController {

	@Bean // 这个注解会从Spring容器拿出Bean
	public WebSocketHandler infoHandler() {
		return new WebSocketHandler();
	}

	@RequestMapping(value="login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		System.out.println(username + "登录");
		HttpSession session = request.getSession(false);
		session.setAttribute("SESSION_USERNAME", username);
		return new ModelAndView("sendwebsocket");
	}

}
