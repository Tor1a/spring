package com.jjang051.model;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Repository
public class TodoDto {
	private int no;
	private String todo;
	private String pickedDate;
	private String done;
	
	
}
