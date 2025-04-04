<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("orderer") %>님의 주문 결과</title>
</head>
<body>
	<h1>주문자명 : <%= request.getParameter("orderer") %></h1>
	<h3>주문한 커피 : 
		<%-- ice 골랐을때 차가운 / hot 골랐을때 따뜻한
		
			커피종류 
			
			-> "차가운 아이스아메리카노" , "따뜻한 카푸치노"
		 --%>
		 
		 <% if(request.getParameter("type").equals("ice")) { %>
		 	차가운
		 <% } else { %>
		 	따뜻한
		 <% } %>
	
		 <%= request.getParameter("coffee") %>
	</h3>
	
	<%= request.getParameterValues("opt") %>
	
	<% if(request.getParameterValues("opt") != null) { %>
		<ul>
			<% for(String opt : request.getParameterValues("opt")) { %>
				<li><%= opt %></li>
			<% } %>
		</ul>
	<% } %>
	
</body>
</html>