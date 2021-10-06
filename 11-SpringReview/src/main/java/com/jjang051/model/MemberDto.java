package com.jjang051.model;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Repository
@Getter
@Setter
@ToString
public class MemberDto {
	private int no;
	private String id;
	private String name;
	private String password;
	private int zipcode;
	private String address;
	private String address01;
	private String address02;
	private String hp;
	private String phoneNumber;
	private String phoneMiddleNumber;
	private String phoneLastNumber;
	private String email;
}









