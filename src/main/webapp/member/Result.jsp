<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result</title>
</head>
<body>
	<% if(session.getAttribute("msg").equals("1")) {%>
	<p><%= session.getAttribute("userId")%>님</p>
	<p>로그인이 정상적으로 처리되었습니다.</p>
	<% } else if(session.getAttribute("msg").equals("2")) {%>
	<p><%= session.getAttribute("userId")%>님</p>
	<p>회원가입을 환영합니다!!</p>
	<% } %>
</body>
</html>