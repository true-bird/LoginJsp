<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contentPage=request.getParameter("contentPage");
	if(contentPage==null) contentPage="home.jsp";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" href="./css/default.css?after" rel="stylesheet">
	<title>Main</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<hr>
	<div class="content">
		<jsp:include page="<%= contentPage %>"/>
	</div>
</body>
</html>