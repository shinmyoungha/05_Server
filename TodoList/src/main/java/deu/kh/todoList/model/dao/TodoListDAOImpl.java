package deu.kh.todoList.model.dao;

import java.sql.Connection;
import java.util.List;

import deu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	
	// JDBC 객체 참조 변수 선언 + Properties 참조 변수 선언
	
	// TodoListDAOImpl 생성자 /xml/sql.xml 경로 읽어오기

	@Override
	public List<Todo> todoListFullView(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCompleteCount(Connection conn) {
		// TODO Auto-generated method stub
		return 0;
	}

}
