<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 결과</title>
</head>
<body>
	<h1>회원 가입 결과 페이지 입니다.</h1>
	
	<h3>입력되어 전달된 값들</h3>
	
	<ul>
		<li>ID : ${param.inputId}</li>
		<li>Pw : ${param.inputPw}</li>
		<li>PwCheck : ${param.inputPwCheck}</li>
		<li>Name : ${param.inputName}</li>
		<li>Age : ${param.inputAge}</li>
	</ul>
	
	<%-- 비밀번호가 일치하는 경우 --%>
	<c:if test="${param.inputPw == param.inputPwCheck}">
		<h1 style="color: green;">가입 성공</h1>
	</c:if>
	
	<%-- 비밀번호가 불일치하는 경우 --%>
	<c:if test="${param.inputPw != param.inputPwCheck}">
		<h1 style="color: red;">가입 실패</h1>
	</c:if>
</body>
</html>