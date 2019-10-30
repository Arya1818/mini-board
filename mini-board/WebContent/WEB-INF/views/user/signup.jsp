<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/user/signup" onsubmit="return checkForm()"> <!-- 실행결과를 얘가 받아야지 onsubmit을 쓴다?? -->
	<table border="1">
		<tr>
			<th>이름</th>
			<td><input type="text" name="uiName" id="uiName"></td>
		</tr>		
		<tr>
			<th>아이디</th>
			<td><input type="text" name="uiId" id="uiId"></td>
		</tr>	
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="uiPwd" id="uiPwd"></td>
		</tr>	
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password" name="uiPwdCheck" id="uiPwdCheck"></td>
		</tr>	
		<tr>
			<th colspan="2"><button>회원가입</button></th>
		</tr>	
	</table>	
</form>
<script>
function checkForm(){
	var uiName = document.getElementById('uiName').value;
//	alert(uiName.length);
//	alert(uiName.trim().length); //빈문자열없애줌
	if(uiName.trim().length<2){
		alert("이름은 2글자 이상입니다.");
		document.getElementById('uiName').value ='';
		document.getElementById('uiName').focus();
		return false;
	}
	var uiIdObj = document.getElementById('uiId'); //좀더편함
	if(uiId.value.trim().length<5){
		alert("아이디는 5글자 이상입니다.");
		uiIdObj.value ='';
		uiIdObj.focus();
		return false;
	}
	var uiPwdObj = document.getElementById('uiPwd');
	if(uiPwd.value.trim().length<5){
		alert("비밀번호는 5글자 이상입니다.");
		uiPwdObj.value ='';
		uiPwdObj.focus();
		return false;
	}
	var uiPwdCheckObj = document.getElementById('uiPwdCheck');
	if(uiPwd.value != uiPwdCheckObj.value){
		alert("비밀번호 체크와 비밀번호가 일치하지 않습니다.");
		uiPwdCheckObj.value ='';
		uiPwdCheckObj.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>

<!-- 이벤트는 소문자로 통일! onsubmit="자바스크립트영역!"
submit버튼을 누르면 onsubmit이 실행되어 check함수가 실행되고 check함수의 return 값이 true일 경우에만 폼을 전송한다.
onsubmit 이벤트 속성에 들어가는 함수는 반드시 전송해야 할 경우 true를 반환하고 하지말아야 할 경우 false를 반환하는 형식이어야 한다.

-->