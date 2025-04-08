package edu.kh.todoList.model.service;

import static edu.kh.todoList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService{
	
	private TodoListDAO dao = new TodoListDAOImpl();

	@Override
	public Map<String, Object> todoListFullView() throws Exception{
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// dao 호출 및 반환받기
		// 1) 할 일 목록 얻어오기
		List<Todo> todoList = dao.todoListFullView(conn);
		
		// 2) 완료된 할 일 개수 카운트
		int completeCount = dao.getCompleteCount(conn);
		
		// Map에  1,2 번으로 얻어온 데이터를 세팅하여 리턴
		// -> 메서드에서 반환은 하나의 값 또는 객체밖에 할 수 없기 때문에
		// Map이라는 컬렉션을 이용해 여러값을 한번에 묶어서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		close(conn);
		
		
		return map;
	}

	@Override
	public int todoAdd(String title, String detail) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.todoAdd(conn, title, detail);
		
		// 트랜잭션 제어처리 -> DML (INSERT/UPDATE/DELETE)
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public Todo todoDetail(int todoNo) throws Exception {
		
		Connection conn = getConnection();
		
		Todo todo = dao.todoDetail(conn, todoNo);
		
		close(conn);
		
		return todo;
	}

	@Override
	public int todoComplete(int todoNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.todoComplete(conn, todoNo);
		
		if(result > 0) commit(conn);
		else   		   rollback(conn);
		
		close(conn);
		
		return result;
	}

}
