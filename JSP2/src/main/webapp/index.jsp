<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		index.html 과 index.jsp 차이
		
		html : html, css, js 코드 작성 가능
			+ 정적 페이지(미리 만들어둔 형태 그대로)	
		
		
		jsp : html, css, js, java, el, jstl 작성 가능
			+ 동적 페이지 (요청에 따라 응답화면 변함)
	</pre>
	
	<hr>
	
	<!--  form 태그 method 생략 시 기본값 GET -->
	<form action="/el/test1">
		문자열 입력 : <input type="text" name="str">
		<br>
		정수 입력 : <input type="number" name="intNum">
		<br>
		실수 입력 : <input type="text" name="doubleNum">
		
		<div>
			A <input type="checkbox" name="check" value="A">
			B <input type="checkbox" name="check" value="B">
			C <input type="checkbox" name="check" value="C">
		</div>
		
		<button>제출하기</button>
	</form>
	
	
	<hr>
	
	<h1>
		<%-- a 태그 클릭시 요청은 GET 방식 --%>
		<a href="/el/scope">Servlet/JSP 범위(scope)별 내장 객체 + EL 사용법</a>
	</h1>
		
		
	<hr>
	
	<h1>
		<a href="/jstl/test">JSTL 간단히 다뤄보기</a>
	</h1>
	
	<hr>
	
	<h1>
		<a href="/book/list">책 목록 조회하기</a>
	</h1>
	
	<hr>
	
	<h1>forward와 redirect</h1>
	
	<h3>forward : 요청 위임</h3>
	
	<pre>
		- 클라이언트 요청을 받은 Servlet/JSP가
		  직접 응답하는것이 아닌
		  다른 Servlet/JSP에
		  HttpServletRequest, HttpServletResponse
		  객체를 넘겨서(위임) 대신 응답하게 하는 것
		 
		- 요청 위임 시
		  RequestDispatcher(요청 발송자)를 이용
		 
		- 요청 위임할 JSP ***파일 경로*** 작성
		
		- 응답 화면(결과 페이지) 주소는
		  처음 Servlet이 요청 받은 주소 그대로!
	</pre>
	
	<form action="/fr/forward">
		forward 입력 1 : <input type="text" name="forwardInput1">
		<br>
		forward 입력 2 : <input type="text" name="forwardInput2">
		<button>forward 확인하기</button>
	</form>
	
	<hr>
	
	<h3>redirect (재요청, 다른 Servlet 요청)</h3>
	
	<pre>
		- 클라이언트의 요청을 받은 Servlet에서
		  직접 응답하지 않고,
		  다른 Servlet을 다시 요청하는 것
		 
		- 보통 Servlet 요청 처리 후
		  특정 JSP로 요청을 위임해
		  결과 화면을 응답해 주는 것이 아닌
		  (요청 받은 Servlet이 응답해줄 JSP가 없음)
		 
		  다른 Servlet을 다시 요청하여
		  다른 Servlet의 결과 화면을 응답해줌
		 		 
	    - redirect는 다시 요청 하는 것!!!
	      -> 기존 req, resp 객체가 사라지고
	         새로운 req, resp 객체가 생성된다.
	        
	         -> request scope에 세팅된 값들이 모두 사라짐
	        
	    - redirect는 응답 화면의 주소가
	      처음 요청한 Servlet 주소가 아닌
	      재요청한 Servlet 주소로 변경된다
	     
	    - 다른 Servlet을 요청하기 위해서는
	      "요청 주소"를 작성해야 한다.
	</pre>
	
	<form action="/fr/redirect">
		redirect 입력 1 : <input type="text" name="redirectInput1">
		<br>
		redirect 입력 2 : <input type="text" name="redirectInput2">
		<button>redirect 확인하기</button>
	</form>
	
</body>
</html>