package com.jjang051.model;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Repository
public class GalleryDto {
	private int no;
	private String title;
	private String contents;
	private String img;
	private String realImg;
}
