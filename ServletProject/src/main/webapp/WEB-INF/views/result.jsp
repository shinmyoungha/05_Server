<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- JSP 주석 
	
		<%@ %> : 지시자 태그 (JSP 페이지의 전반적 속성을 설정하는데 사용하는 태그)
		
		<% %> : 스크립틀릿 -> 자바코드 작성
		
		<%= %> : 표현식 -> 자바, 서버에서 받아온 값을 표현(출력)할 때 사용
		
		JSP ( Java Server Page ) : Java 코드가 포함된 HTML 코드
		
	--%>
	
	<h3 style="color : hotpink;"><%= request.getParameter( "inputName" ) %>님의 가입을 환영합니다.</h3>
	
	<ul>
		<li>id : <%= request.getParameter( "inputId" ) %></li>
		<li>pw : <%= request.getParameter( "inputPw" ) %></li>
	</ul>
	
	
	<% if( !request.getParameter( "intro" ).equals("") ) { %>
		<h4>자기소개</h4>
		<p><%= request.getParameter( "intro" ) %></p>
	<% } %>
</body>
</html>