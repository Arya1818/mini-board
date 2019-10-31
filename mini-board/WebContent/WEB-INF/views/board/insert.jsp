<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("user")==null){
	response.sendRedirect("/");
}
if(request.getAttribute("msg")!=null){
%>
<script>
	alert('<%=request.getAttribute("msg")%>');
</script>
<%
}
Map<String,Object> user = (Map<String,Object>)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/views/board/insert" onsubmit="return checkForm()">
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" name="biTitle" id="biTitle"></td> 
		</tr>	
		<tr>
			<th>내용</th>
			<td><input type="text" name="biContent" id="biContent"></td> 
		</tr>
		<tr>
			<th colspan="2"><button>글쓰기</button></th>
		</tr>
	</table>
</form>
<script>
function checkForm(){
	var biTitle = document.getElementById('biTitle').value;
	var biContent = document.getElementById('biContent').value;
	if(biTitle=='' || biContent=='' ){
		alert('제목과 내용을 입력해주세요');
		return false;
	}else{
		alert('등록완료');
	}
	return true;
}
</script>
</body>
</html>