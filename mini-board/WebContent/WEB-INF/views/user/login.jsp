<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//String test = request.getAttribute("test"); //에러나는 이유? 넘겨받은 test의 value는  object인데 string에 어떻게 넣니? 
String test = (String)request.getAttribute("test");	//형변환(캐스팅)
		
%>
<%=test %>
난 로그인화면 만들 예정
</body>
</html>