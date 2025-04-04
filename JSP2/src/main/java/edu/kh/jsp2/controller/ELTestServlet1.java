package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/el/test1")
public class ELTestServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 요청처리
		// --------------
		// 응답처리
		
		RequestDispatcher dispatcher 
		= req.getRequestDispatcher("/WEB-INF/views/el/test1.jsp");
		
		dispatcher.forward(req, resp);
	}
}
