package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request scope 속성 추가
		req.setAttribute("str2", "가나다라마바사");
		
		// session scope 속성 추가
		HttpSession session = req.getSession();
		session.setAttribute("sessionNum", 10000);
		
		// 재요청 (redirect)
		
		// resp.sendRedirect("다시 요청할 Servlet 주소")
		// -> 파일 경로가 아닌!!
		// 	  다시 요청할 Servlet의
		//	  @WevServlet(주소)에 작성된 주소를 작성해야함
		// *** 재요청(redirect)은 Get 요청 ***
		resp.sendRedirect("/fr/result");
	}
}
