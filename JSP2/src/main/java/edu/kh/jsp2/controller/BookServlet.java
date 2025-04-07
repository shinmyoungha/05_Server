package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 처리
		
		// Book 으로 타입이 제한된 List 생성
		List<Book> bookList = new ArrayList<Book>();
		
		// bookList에 데이터 추가(Service <-> DAP -> DB)
		bookList.add(new Book("자바란 무엇인가", "둘리", 10000));
		bookList.add(new Book("HTML이란 무엇인가", "홍길동", 20000));
		bookList.add(new Book("JS란 무엇인가", "이순신", 15000));
		bookList.add(new Book("CSS란 무엇인가", "짱구", 50000));
		bookList.add(new Book("Servlet란 무엇인가", "훈이", 40000));
		bookList.add(new Book("JSP란 무엇인가", "철수", 80000));
		bookList.add(new Book("Spring란 무엇인가", "유리", 80000));
		
		// bookList를 요청 위임된 JSP에서도 유지하여 사용할 수 있도록
		// request scope 객체에 속성으로 추가(세팅)
		req.setAttribute("bookList", bookList);
		
		// 응답 처리
		// JSP로 요청 위임 (webApp 폴더 기준!)
		req.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp").forward(req, resp);
	}
}
