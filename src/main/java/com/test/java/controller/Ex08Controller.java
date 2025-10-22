package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.java.service.SpringService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Ex08Controller {
	
	private final SpringService service;
	
//	@Autowired
//	public Ex08Controller(SpringService service) {
//		this.service = service;
//	}
	
	//@RequestMapping
	//@GetMapping
	//@PostMapping
	
	@GetMapping("/ex08.do")
	public String ex08(Model model) {
		
		//Controller > (의존) > Service > (의존) > DAO
		//SpringService service = new SpringService(); //@autowired로 인해 사라져도 됨
		
		String data = service.work();
		
		model.addAttribute("data", data);
		
		return "ex08";
	}

}
