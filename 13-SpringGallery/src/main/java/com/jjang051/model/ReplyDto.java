package com.jjang051.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReplyDto {
	private int no;
	private int boardId;
	private String reply;
}
