package com.test.java.service;

import org.springframework.stereotype.Service;

import com.test.java.model.SpringDAO;

import lombok.RequiredArgsConstructor;


@Service
//@NoArgsConstructor //default constructor
//@AllArgsConstructor  // 모든 멤버  변수를 인수로 가지는 생성자
@RequiredArgsConstructor //반드시 초기화가 필요한 멤버변수
public class SpringService {
	
	
	//의존 주입 도구 > @Autowired 선언
	// - Spring 2.5부터
	
	//1. @Autowired + 생성자
//	private SpringDAO dao;
//	
//	//의존 주입 도구 > @Autowired 선언
//	//- Spring 2.5 부터
//	@Autowired
//	public SpringService(SpringDAO dao) {
//		this.dao = dao;
//	}
	
	
	
	//2. @Autowired + Setter
//	private SpringDAO dao;
//	
//	@Autowired
//	public void setDao(SpringDAO dao) {
//		this.dao = dao;
//	}

	
	//3. 멤버 변수에 직접 @Autowired 선언
	// - 의존 주입 도구(생성자, setter)가 필요 없다.
	// - 가장 손쉬운 방법
	// - 테스트와 유지보수가 어렵다.
	/*
	 * @Autowired 
	 * private SpringDAO dao;
	 */
	
	
	//4. 생성자 + @Autowired 생략
	// - Spring 4.3 부터 지원
	// - 생성자가 딱 1개일때만 지원
	// - 스프링이 객체를 생성할 때 > 생성자 1개밖에 > 자동으로 @Autowired를 적용한다.
//	private SpringDAO dao;
//	
//	@Autowired
//	public void setDao(SpringDAO dao) {
//		this.dao = dao;
//	}
//	
//	public void setDao(SpringDAO dao, int num) {
//		this.dao = dao;
//	}
	
	
	//5. Lombok + Setter
	// - Lombok에게 나 대신 Setter를 만들게 한다.
	// - 의존 주입 도구를 Lombok을 통해서 생성하자.
//	@Setter(onMethod = @Authwired)
//	private SpringDAO dao;
	
	
	//6. Lombok + 생성자 사용
	private final SpringDAO dao; //반드시 requiredArgsConstructor 
	private int num;
	private String name;
	
	

	public String work() {


		SpringDAO dao = new SpringDAO();
		
		String data = dao.work();
		
		return data;
	}

}
