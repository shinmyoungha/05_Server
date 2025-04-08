package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/add")
public class TodoAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할 일 추가
		try {
			
			// 1. TodoListServiceImpl 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 2. 요청 시 전달받은 파라미터 데이터 얻어오기
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			
			// 3. 서비스 호출 후 결과 반환받기
			int result = service.todoAdd(title, detail);
			
			// 4. 성공/실패 메시지 세팅하기
			String message = null;
			if(result > 0) message = "추가 성공!";
			else		   message = "추가 실패...";
			
			// 5. 기존 req를 사용할 수 없기 때문에
			// session 을 이용해서 message를 세팅
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			// 6. 메인페이지로 redirect(재요청)
			resp.sendRedirect("/"); 
			// -> "/" 최상위 경로로 재요청을 보냄.
			// -> "/" 처리하는 Servlet 재요청됨.
			// -> "/" -> "/main" (GET)
			// redirect는 무조건 GET방식! 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
