package com.jjang051.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jjang051.model.TodoDao;
import com.jjang051.model.TodoDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class TodoController {

	@Autowired
	TodoDao todoDao;

	@Autowired
	TodoDto todoDto;

	@RequestMapping("/InsertTodo.do")
	@ResponseBody
	public Map<String, Object> insertTodo(@RequestBody TodoDto todoDto) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		int result = todoDao.insertTodo(todoDto);
		String pickedDate = todoDto.getPickedDate();
		log.info("pickedDate = {}",pickedDate);
		List<TodoDto> todoList = null;
		if (result > 0) {
			todoList = todoDao.getTodoList(pickedDate);
			hashMap.put("todoList", todoList);
		}
		return hashMap;
	}

	@RequestMapping("/GetTodoList.do")
	@ResponseBody
	public Map<String, Object> getTodoList(@RequestBody TodoDto todoDto) {
		log.info("47===/GetTodoList.do todoDto==={}",todoDto);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		String pickedDate = todoDto.getPickedDate();
		List<TodoDto> todoList = todoDao.getTodoList(pickedDate);
		hashMap.put("todoList", todoList);
		return hashMap;
	}
	
	@RequestMapping("/DeleteTodo.do")
	@ResponseBody
	public Map<String, Object> deleteTodo(@RequestBody TodoDto todoDto) {
		log.info("58===/DeleteTodo.do todoDto==={}",todoDto);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		int no = todoDto.getNo();
		int result = todoDao.deleteTodo(no);
		hashMap.put("result", result);   //{"result":1}
		return hashMap;
	}
	
	@RequestMapping("/UpdateTodo.do")
	@ResponseBody
	public Map<String, Object> updateTodo(@RequestBody TodoDto todoDto) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		int no = todoDto.getNo();
		int result = todoDao.updateTodo(todoDto);
		hashMap.put("result", result);   //{"result":1}
		return hashMap;
	}
	
}












