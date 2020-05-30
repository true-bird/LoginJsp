<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" href="./css/header.css" rel="stylesheet">
	<title>Header</title>
</head>
<body>
	<div id = "menu">
		<h1 id = "menuText">
			<a href="Main.do">홈</a> |
			<a href="Players.do">선수단</a> |
			<%
				String userId = "";
				if(session.getAttribute("userId")!=null) {
					userId = session.getAttribute("userId").toString();
					out.println("<a href='Favorites.do'>즐겨찾기</a> |");
					out.println("<a href='LogoutAction.do'>로그아웃</a>");
				} else {
					out.println("<a href='Signup.do'>회원가입</a> |");
					out.println("<a href='Login.do'>로그인</a>");
				}
			%>
		</h1>
		<% if(userId!="") out.println("<p id='loginCheck' style='margin-right:10px'>"+userId+"님 </p>");%>
	</div>
</body>
</html>