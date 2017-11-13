<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
hahhah
</body>
<script type="text/javascript">
//获取链接参数
function getParams(key){
	    var url = location.search.replace(/^\?/,'').split('&');
	    var paramsObj = {};
	    for(var i = 0, iLen = url.length; i < iLen; i++){
	        var param = url[i].split('=');
	        paramsObj[param[0]] = param[1];
	    }
	    if(key){
	        return paramsObj[key] || '';
	    }
	    return paramsObj;
	}
</script>
</html>