package edu.kh.todoList.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		
		// service 요청 (userId/ userPw가 둘 다 맞는 회원이 있는지 DB에서 조회)
		// 결과값 반환 (User & null)
		
		// session scope에 로그인한 회원의 정보를 저장!
		// 브라우저 종료 및 세션 만료 외에는
		// 모든 페이지에서 로그인정보를 이용할 수 있게끔 해야함
		HttpSession session = req.getSession();
		session.setAttribute("loginMember", userId);
		
		resp.sendRedirect("/");
	}
}
