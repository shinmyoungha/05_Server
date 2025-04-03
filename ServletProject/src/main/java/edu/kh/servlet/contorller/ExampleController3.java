package edu.kh.servlet.contorller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		/*
		 * getParameter("name") : 같은 name 속성을 가진 여러개 값 중 첫번째 값만 반환
		 * getParameterValues("name") : 같은 name 속성을가진 모든 값을 배열(String[])로 반환
		 * 
		 * */
		
		String option = req.getParameter("opt");
		String[] optionArr = req.getParameterValues("opt");
		
		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(option);
		System.out.println(optionArr); // 주소값 출력
		
		for(String opt : optionArr) {
			System.out.println(opt);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		
		dispatcher.forward(req, resp);
	}
}
