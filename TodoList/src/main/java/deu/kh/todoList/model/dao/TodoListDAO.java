package deu.kh.todoList.model.dao;

import java.sql.Connection;
import java.util.List;

import deu.kh.todoList.model.dto.Todo;

public interface TodoListDAO {

	List<Todo> todoListFullView(Connection conn);

	int getCompleteCount(Connection conn);

}
