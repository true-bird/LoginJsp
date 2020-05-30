<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> list = new ArrayList<String>((Set)session.getAttribute("imgPath"));
	HashMap<String,String> hashMap= new HashMap<>();
	for(String key : list) {
		String value = "";
		switch(key) {
			case "./img/player01.jpg":
				value = "김하성";
				break;
			case "./img/player02.jpg":
				value = "조상우";
				break;
			case "./img/player03.jpg":
				value = "이정후";
				break;
			case "./img/player04.jpg":
				value = "박병호";
				break;
			case "./img/player05.jpg":
				value = "최원태";
				break;
			case "./img/player06.jpg":
				value = "서건창";
				break;		
		}
		hashMap.put(key,value);
	}

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Favorites</title>
	<script type="text/javascript" src="./js/favorites.js"></script>
</head>
<body>
	<form class="form" action="DelFavAction.do" method="post">
		<%
			if(list.size()==0) {
		%>
		<p>즐겨찾기 된 선수가 없습니다.</p>
		<%	
			} else {
		%>
		<table id="favorites">		
			<tr>
			<%
				for(int i=0;i<list.size();i++) {
			%>
			<%
				if(i%2==0) {
			%>
			</tr>
			<tr>
			<% } %>
			<td>
				<img class = "palyerImg" src="<%=list.get(i)%>">
				<br>
				<label>
				<%= hashMap.get(list.get(i)) %>
				</label>
				<input name="favorite" value="<%=list.get(i)%>" type="checkbox">
			</td>
			<% } %>
			</tr>
		</table>
		<% } %>
		<hr>
		<% if(list.size()!=0) { %>
		<input class="burgundyButton"  name = "delFav" type="submit" value="삭제"/>
		<% } %>
	</form>
</body>
</html>