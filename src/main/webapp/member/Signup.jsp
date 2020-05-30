<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/signup.js"></script>
<title>Sign up</title>
<%
%>
</head>
<body>
	<form class="form" action="SignupAction.do" method="post">
		<div class="inputBox">
			<label>아이디</label>
			<input id="checkButton" value="중복체크" type="button">
			<input id="userId" type="text" name="userId" minlength="5"maxlength="20">&nbsp;&nbsp;(입력:5~20 글자)
		</div>
		<div class="inputBox">
			<label>패스워드</label>
			<input id="userPassword" type="password" name="userPassword" minlength="5" maxlength="20">&nbsp;&nbsp;(입력:5~20 글자)
		</div>
		<div class="inputBox">
			<label>패스워드(확인)</label>
			<input id="userPasswordCheck" type="password" minlength="5" maxlength="20">&nbsp;&nbsp;(입력:5~20 글자)
		</div>
		<div class="inputBox">
			<label>이름</label>
			<input id="userName" name="userName" type="text" minlength="3" maxlength="20">&nbsp;&nbsp;(입력:3~20 글자)
		</div>
		<div class="inputBox">
			<label>성별</label>
			<input type="radio" name="gender" value="male" checked="checked">남자
			<input type="radio" name="gender" value="female">여자
		</div>
		<div class="inputBox">
			<label>생년월일</label>
			<select id="year" name="year"></select>년 
			<select id="month" name="month"></select>월 
			<select id="day" name="day"></select>일
		</div>
		<div>
			<input class="burgundyButton" id="regButton" value="등록" type="submit">
		</div>
	</form>
</body>
</html>