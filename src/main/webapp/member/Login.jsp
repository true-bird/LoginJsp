<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = request.getParameter("fail");
	String id = "";
	boolean chk = false;
	if (msg != null) {
		if (msg.equals("-1"))
			out.println("<script>alert('아이디를 확인해 주시기 바랍니다.');</script>");
		else if (msg.equals("-2"))
			out.println("<script>alert('패스워드를 확인해 주시기 바랍니다.');</script>");
	}

	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for(Cookie c : cookies) {
			if(c.getName().equals("userId")) {
				id = c.getValue();
				chk = true;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/login.js"></script>
<title>Login</title>
</head>
<body>
	<form class="form" action="LoginAction.do" method="post">
		<div class="inputBox">
			<label>아이디</label>
			<input type="checkbox" name="save" value="save" <%if(chk) { %> <%="checked="+chk %> <%}%>>아이디 저장
			<input id="userId" type="text" name="userId" value="<%= id %>" minlength="5" maxlength="20">&nbsp;&nbsp;(입력:5~20 글자)
		</div>
		<div class="inputBox">
			<label>패스워드</label>
			<input id="userPassword" type="password" name="userPassword" minlength="5" maxlength="20">&nbsp;&nbsp;(입력:5~20 글자)
		</div>
		<input class="burgundyButton" value="로그인" type="submit">
	</form>
</body>
</html>