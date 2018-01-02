<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/sockjs.js"></script>
	<script type="text/javascript">
		var soc = null;
		if ('WebSocket' in window) {
			soc = new WebSocket('ws://'+window.location.host+'/trade/mywebsocket.do');
		} else if ("MoWebSocket" in window) {
			soc = new MoWebSocket('ws://'+window.location.host+'/trade/mywebsocket.do');
		} else {
			soc = new SockJS(
					'http://'+window.location.host+'/trade/sockjs/mywebsocket.do');
		}
		soc.onopen = function(){
			  alert("连接建立成功。。。。");
			  soc.send("哈哈，this is me ,请多多关照");
			  
		} 
		//弹出返回的信息	
		soc.onmessage=function(evt){
			alert(evt.data)
		}
		
		//主要起侦听作用
		soc.onerror =function(){
			alert("当心出错了。。。。");
		}
		//此处监听会先行侦听连接是否建立，会首选触发服务端afterConnectionClosed()方法
	    soc.onclose = function(){
			 alert("连接已关闭");
		}

		function doSend() {
			if (soc.readyState==1) {
				var msg = document.getElementById("inputMsg").value;
				soc.send(msg);//调用后台handleTextMessage方法
				alert("发送成功!");
			} else {
				alert("连接失败!");
			}
		}
	</script>
	请输入：<input type="text"id="inputMsg" name="inputMsg"></input>
	<button onclick="doSend();">发送</button>
</body>
</html>