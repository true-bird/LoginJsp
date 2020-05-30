<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%
	boolean chk = true;
	Set<String> imgSet = new HashSet<>();
	if(session.getAttribute("userId")==null) chk = false;
	if(session.getAttribute("imgPath")!=null) imgSet = (HashSet<String>)session.getAttribute("imgPath");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/players.js"></script>
<title>Player</title>
</head>
<body>
	<form class="form" action="FavoritesAction.do" method="post">
		<table id="players">
			<tr>
				<td>
					<img class = "palyerImg" src="./img/player01.jpg">
				</td>
				<td>
					<img class = "palyerImg" src="./img/player02.jpg">
				</td>
				<td>
					<img class = "palyerImg" src="./img/player03.jpg">
				</td>
			</tr>
			<tr>
				<td>
					<label>김하성</label>
					<%if(!imgSet.contains("./img/player01.jpg")) {%>
					<input name="player" value="./img/player01.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
				<td>
					<label>조상우</label>
					<%if(!imgSet.contains("./img/player02.jpg")) {%>
					<input name="player" value="./img/player02.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
				<td>
					<label>이정후</label>
					<%if(!imgSet.contains("./img/player03.jpg")) {%>
					<input name="player" value="./img/player03.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
			</tr>
			<tr>
				<td>
					<img class = "palyerImg" src="./img/player04.jpg">
				</td>
				<td>
					<img class = "palyerImg" src="./img/player05.jpg">
				</td>
				<td>
					<img class = "palyerImg" src="./img/player06.jpg">
				</td>
			</tr>
			<tr>
				<td>
					<label>박병호</label>
					<%if(!imgSet.contains("./img/player04.jpg")) {%>
					<input name="player" value="./img/player04.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
				<td>
					<label>최원태</label>
					<%if(!imgSet.contains("./img/player05.jpg")) {%>
					<input name="player" value="./img/player05.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
				<td>
					<label>서건창</label>
					<%if(!imgSet.contains("./img/player06.jpg")) {%>
					<input name="player" value="./img/player06.jpg" type="checkbox"><%} else {%>
					<span>★</span>
					<%} %>
				</td>
			</tr>
		</table>
		<hr>		

		<input class="burgundyButton"  name = "fav" <%if(!chk) { %> <%="id='impossible'" %> <%}%>type="submit" value="즐겨찾기"/>
	</form>
</body>
</html>