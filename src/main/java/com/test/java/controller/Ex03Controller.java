package com.test.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//컨트롤러 구현
//1. Controller 인터페이스 구현
//2. @Controller 어노테이션 사용
@Controller
@RequestMapping(value = "/ex03.do")
public class Ex03Controller {
	
	//doGet(), doPost(), handleRequest() > 예약 메서드 (약속이 안되어있음)
	
	//요청 메서드 역할
	@RequestMapping
	public String test(HttpServletRequest req) {
		
		String name = "강아지";
		
		req.setAttribute("name", name);
		
		return "ex03";
		
	}

}
