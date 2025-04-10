<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${todo.todoTitle} 상세 조회</title>
	<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

	<h1>${sessionScope.loginMember}</h1>
	
	<h1>${todo.todoTitle}</h1>

	<div class="complete">
		완료 여부 :
		
		<c:if test="${todo.todoComplete}">
			<span class="green">O</span>
		</c:if>
		
		<c:if test="${not todo.todoComplete}">
			<span class="red">X</span>
		</c:if>
	</div>

	<div>
		작성일 : ${todo.regDate}
	</div>

	<div class="content">${todo.todoDetail}</div>
	
	<div class="btn-container">
		<div>
			<button type="button" id="goToList">목록으로</button>
		</div>
		
		<div>
			<button id="completeBtn">완료 여부 변경</button>
			<button id="updateBtn">수정</button>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>
	
	
	
	<%-- session 범위에 message가 있을 경우 --%>
	<c:if test="${not empty sessionScope.message}">
		<script>
			alert("${message}");
		</script>
		
		<c:remove var="message" scope="session" />
	</c:if>
	
	
	<script src="/resources/js/detail.js"></script>
</body>
</html>