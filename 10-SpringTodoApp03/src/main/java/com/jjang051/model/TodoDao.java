package com.jjang051.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
	//연결
	private static SqlSessionFactory sqlFSessionFactory;
	static {
		try {
			String resource = "com/jjang051/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlFSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertTodo(TodoDto todoDto) {
		int result = 0;
		SqlSession sqlSession = sqlFSessionFactory.openSession();
		result =  sqlSession.insert("insertTodo",todoDto);
		sqlSession.commit();
		sqlSession.close();
		return result; 
	}
	
	public List<TodoDto> getTodoList(String pickedDate) {
		List<TodoDto> todoList = null;
		SqlSession sqlSession = sqlFSessionFactory.openSession();
		todoList = sqlSession.selectList("getTodoList",pickedDate);
		return todoList;
	}
	
	public int deleteTodo(int no) {
		int result = 0;
		SqlSession sqlSession = sqlFSessionFactory.openSession();
		result = sqlSession.delete("deleteTodo",no);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
	
	
	public int updateTodo(TodoDto todoDto) {
		int result = 0;
		SqlSession sqlSession = sqlFSessionFactory.openSession();
		result = sqlSession.update("updateTodo",todoDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}



















