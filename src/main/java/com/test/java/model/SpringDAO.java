package com.test.java.model;

import org.springframework.stereotype.Repository;

@Repository
public class SpringDAO {

	public int count() {
		
		//select count(*)
		
		return 100;
	}

	public String work() {
		
		//select...
		
		return "스프링";
	}

}
