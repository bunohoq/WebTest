package com.test.java.model;

import lombok.Getter;

//@Getter
public class Student {

	private String name;
	private String gender;
	
	public String getTest() {
		return name;
	}

	public String aaa() {
		return gender;
	}

	public Student() {
		this.name = "스프링";
		this.gender = "남자";
	}
	
}



