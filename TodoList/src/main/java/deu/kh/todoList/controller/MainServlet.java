package deu.kh.todoList.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/main" 요청을 매핑하여 처리하는 서블릿

@WebServlet("/main")
public class MainServlet extends HttpServlet{

	// 왜 index.jsp에서 메인페이지 코드 작성하지 않고
	// /main 요청을 처리하는 서블릿을 만들었는가?
	
	// - Servlet(Back-End)에서 추가한(조회한) 데이터
	// 	 메인페이지에서부터 사용할 수 있게 하기 위해..
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// DB에 갔다오는일!
		// 요청 -> Controller -> Service -> DAO -> DB
		// 응답	<-	view	  <-		 <- 	<-
		
	}
}
