<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("user")==null){
	response.sendRedirect("/"); //요청을 새로 만듦 , url바뀜,
}

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일자</th>

	</tr>
<%
	if(request.getAttribute("list")==null){
		out.println("<tr><td colspan=\"4\">게시물이없습니다.</td></tr>");
		
	}else{
		List<Map<String,String>> boardList =
				(List<Map<String,String>>) request.getAttribute("list");
		for(Map<String,String> board:boardList){
%>
	<tr>
		<td><%=board.get("biNum") %></td>	
		<td><%=board.get("biTitle") %></td>
		<td><%=board.get("uiNum") %></td>
		<td><%=board.get("credat") %></td>
	</tr>
<%
		}
	}
%>				


</table>
<a href = "/views/board/insert"><button>글쓰기</button></a>
</body>
</html>