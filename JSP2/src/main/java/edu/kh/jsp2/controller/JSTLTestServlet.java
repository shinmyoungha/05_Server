package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/test")
public class JSTLTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// c:forEach 연습을 위한 List 생성
		List<String> nameList = new ArrayList();
		
		nameList.add("짱구");
		nameList.add("훈이");
		nameList.add("유리");
		nameList.add("철수");
		nameList.add("맹구");
		nameList.add("진구");
		nameList.add("비실이");
		nameList.add("퉁퉁이");
		nameList.add("이슬이");
		nameList.add("도라에몽");
		
		// request scope 객체에 속성으로 List 를 세팅
		// (현재 Servlet -> 위임된 JSP 까지 유효)
		req.setAttribute("nameList", nameList);
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/test.jsp").forward(req, resp);
	}
}
