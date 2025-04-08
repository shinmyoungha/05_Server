package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/todo/detail")
public class DetailServlet extends HttpServlet{
	
	// a 태그 요청은 무조건 Get 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 할 일 상세 조회 요청 처리 Servlet
		try {
			
			// 서비스 객체 생성
			TodoListService service = new TodoListServiceImpl();
			
			// 요청 시 전달받은 파라미터 얻어오기
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			// 알맞은 서비스 호출 후 결과 반환 받기
			Todo todo = service.todoDetail(todoNo);
			// TODO_NO 컬럼값이 todoNo와 같은 todo가 
			// 있으면 해당 Todo 객체 반환
			// 없으면 null 반환
			
			// todo가 존재하지 않을 경우
			// -> 메인페이지 redirect 후
			// "할 일이 존재하지 않습니다" alert 출력 
			if(todo == null) {
				
				// session 객체 생성 후 message 세팅하기
				HttpSession session = req.getSession();
				session.setAttribute("message", "할 일이 존재하지 않습니다.");
				
				resp.sendRedirect("/");
				return;
			}
			
			// todo가 존재하는 경우
			// detail.jsp 로 forward로 응답
			req.setAttribute("todo", todo);
			
			String path = "/WEB-INF/views/detail.jsp";
			
			// 요청발송자 이용해서 요청 위임
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
