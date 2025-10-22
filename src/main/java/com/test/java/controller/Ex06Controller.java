package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping(value = "/board")
public class Ex06Controller {

	@GetMapping(value = "/ex06.do")
	public String ex06() {
		
		return "ex06";
	}
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(HttpServletRequest req) {
		
		//요청 메서드는 스프링 컨테이너가 생성할 수 있는 자원은
		//매개변수를 통해서 전달 받을 수 있다. ??
		
		//System.out.println(req != null); //true
		
//		try {
//			req.setCharacterEncoding("UTF-8"); // > 필터
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		String data = req.getParameter("data");
		
		req.setAttribute("data", data);
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam("data") String data, Model model) {
		
		//기존 방식
		//- req.getParameter("key")
		
		//스프링 방식
		//- @RequestParam("key")
		//- 파라미터 자동 수집 기능
		
		System.out.println(data);
		
		model.addAttribute("data", data);
		
		return "ex06ok";
	}
	*/
	
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam("data") String data, Model model) {
		
		int num = Integer.parseInt(data);
		
		model.addAttribute("data", num * 2);
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam("data") int data, Model model) {
		
		model.addAttribute("data", data * 3);
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam("data") boolean data, Model model) {
		
		//Boolean.parseBoolean(data) > true
		
		model.addAttribute("data", data ? "참" : "거짓");
		
		return "ex06ok";
	}
	*/
	
	

	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam(name = "data", defaultValue = "기본값") String data, Model model) {
		
		//defaultValue
		//- 값이 null or "" > 대신할 값
		
//		if (data.equals("") || data == null) {
//			data = "기본값";
//		}
		
		System.out.println(data.equals(""));
		System.out.println(data == null);
		
		model.addAttribute("data", data);
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(@RequestParam(name = "data", required = false) String data, Model model) {
		
		//System.out.println(data.equals(""));
		System.out.println(data == null);
		
		model.addAttribute("data", data);
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(String data, Model model) {
		
		//@RequestParam 생략 가능 조건
		//- 태그의 name과 매개변수의 이름이 동일해야 한다.
				
		model.addAttribute("data", data);
		
		return "ex06ok";
	}
	*/
	
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model, 
					@RequestParam("name") String name,
					@RequestParam("age") Integer age,
					@RequestParam("address") String address) {
		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(address);
		
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		SpringDAO dao = new SpringDAO();
		
		dao.add(dto);
		
		
		return "ex06ok";
	}
	*/
	
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model, String name, Integer age, String address) {
		
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		SpringDAO dao = new SpringDAO();
		
		dao.add(dto);
		
		
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model, AddressDTO dto) {
		
		//태그의 name과 DTO의 setter명이 동일!! > 자동 파라미터 수집 가능
		
		SpringDAO dao = new SpringDAO();
		
		dao.add(dto);
				
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model, AddressDTO dto, String id) {
		
		SpringDAO dao = new SpringDAO();
		
//		AddressDTO(name=홍길동, age=20, address=서울시 강남구 대치동)
//		hong
		dao.add(dto);
		System.out.println(id);
				
		return "ex06ok";
	}
	*/
	
	/*
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model
					//, @RequestParam("cb") String[] cb) {
					//, String[] cb) { 
					//, @RequestParam("cb") List<String> cb) {
					//, @RequestParam("cb") ArrayList<String> cb) {
					, ArrayList<String> cb) {
		
		//[독서, 운동, 여행]
		//[독서, 여행]
		//System.out.println(Arrays.toString(cb));
		System.out.println(cb);
				
		return "ex06ok";
	}
	*/
	
	@PostMapping(value = "/ex06ok.do")
	public String ex06ok(Model model,
						@ModelAttribute("data") String data) {
		
		//@ModelAttribute = getParameter + addAttribute
		
		//model.addAttribute("data", data);
		
		return "ex06ok";
	}
	
	
}
























