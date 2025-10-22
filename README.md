# Spring MVC 컨트롤러 주요 기능 예제

이 저장소는 Spring Framework (Legacy) 환경에서 컨트롤러(`@Controller`)를 구현하는 다양한 방법을 정리한 예제 코드 모음임.

<br>

## 📌 주요 학습 내용

* **컨트롤러 구현 방식**: `Controller` 인터페이스를 구현하는 고전적인 방식과 `@Controller` 어노테이션을 사용하는 현대적인 방식을 비교함.
* **URL 매핑**: `@RequestMapping`, `@GetMapping`, `@PostMapping`을 사용하여 클래스와 메서드 레벨에서 URL을 매핑함.
* **HTTP Method 처리**: 특정 HTTP 메서드(GET, POST) 요청만 처리하도록 URL을 제한함.
* **데이터 수신 (Parameter)**: 클라이언트가 보낸 데이터를 받는 다양한 방법을 연습함.
    * `HttpServletRequest` 객체 사용
    * `@RequestParam` 어노테이션 활용 (옵션: `defaultValue`, `required`)
    * 커맨드 객체(DTO)를 통한 자동 데이터 바인딩
    * `@ModelAttribute`를 사용한 모델 데이터 동시 등록
* **데이터 송신 (View)**: 컨트롤러가 JSP(View)로 데이터를 전달하는 방법을 다룸.
    * `ModelAndView` 객체 사용
    * `Model` 객체 사용
    * `HttpServletRequest` 객체 사용
* **다양한 반환(return) 타입**: 메서드의 반환 타입에 따른 Spring의 동작을 학습함.
    * `String`: JSP 파일명 반환 (ViewResolver)
    * `void`: 요청 URL과 동일한 이름의 JSP 자동 호출
    * `redirect:` / `forward:`: 페이지 이동
* **RESTful API 구현**: `@ResponseBody`와 `@RestController`를 사용하여 JSP가 아닌 JSON 데이터를 반환하는 방법을 다룸.

<br>

## 📁 파일별 상세 설명

### `Ex01Controller.java`

* `org.springframework.web.servlet.mvc.Controller` 인터페이스를 `implements` 한 **고전적인 컨트롤러**임.
* `handleRequest` 메서드를 오버라이드함.
* `ModelAndView` 객체를 사용하여 View 이름과 전달할 데이터를 설정함.

### `Ex02Controller.java`

* `Ex01Controller`와 동일하게 `Controller` 인터페이스를 구현함.
* **생성자 의존 주입(DI)**을 통해 `SpringDAO` 객체를 주입받는 예제임.

### `Ex03Controller.java`

* **`@Controller` 어노테이션**을 사용한 컨트롤러임.
* `@RequestMapping`을 사용하여 특정 URL(`ex03.do`) 요청을 처리할 메서드를 지정함.
* `HttpServletRequest`를 파라미터로 받아 전통적인 방식으로 View에 데이터를 전달함.

### `Ex04Controller.java` / `Ex04GetController.java` / `Ex04PostController.java`

* `@RequestMapping`의 `method` 속성을 사용하여 **HTTP Method를 분리**하는 방법을 보여줌.
* `Ex04Controller`: `GET`과 `POST` 요청을 모두 처리함.
* `Ex04GetController`: `GET` 요청만 처리함.
* `Ex04PostController`: `POST` 요청만 처리함.

### `Ex05Controller.java`

* 하나의 컨트롤러 클래스 안에 **여러 개의 요청 메서드**(`@RequestMapping`)를 구현하는 예제임.
* `@GetMapping`과 `@PostMapping`을 사용하여 `ex05get.do` (GET)와 `ex05post.do` (POST) 요청을 각각 다른 메서드로 처리함.

### `Ex06Controller.java`

* **가장 중요한 예제**로, 클라이언트의 **파라미터를 수신하는 다양한 방법**을 보여줌.
* 주석 처리된 코드를 포함하여 아래의 모든 방식을 테스트함.
    1.  `HttpServletRequest` 객체로 직접 받기 (e.g., `req.getParameter("data")`)
    2.  `@RequestParam("name")` 어노테이션으로 받기
    3.  `@RequestParam`의 **자동 형 변환** (e.g., `String` -> `int`, `boolean`)
    4.  `@RequestParam`의 `defaultValue` 속성 (값이 없거나 null일 때 기본값 지정)
    5.  `@RequestParam`의 `required = false` 속성 (필수 파라미터가 아님을 지정)
    6.  `@RequestParam` 생략 (메서드의 파라미터 변수명과 `<input>`의 `name` 속성이 동일할 경우)
    7.  **커맨드 객체(DTO)** (`AddressDTO dto`)를 사용한 자동 데이터 바인딩 (Setter 필요)
    8.  **배열/리스트** 수신 (e.g., 체크박스 다중 선택)
    9.  `@ModelAttribute`: 파라미터를 받은 즉시 `Model`에 `addAttribute`하는 기능

### `Ex07Controller.java`

* 컨트롤러 메서드의 **다양한 반환(return) 타입**을 보여줌.
    1.  `String`: View(JSP) 파일명 반환 (기본)
    2.  `void`: 요청 URL과 동일한 이름의 JSP 파일을 자동으로 호출
    3.  `"redirect:"` / `"forward:"`: 페이지 이동 처리
    4.  **`@ResponseBody`**: ViewResolver를 거치지 않고, 반환값(String, DTO, List) 자체를 순수 데이터(주로 JSON)로 클라이언트에 전송함.

### `Ex07RestController.java`

* `@Controller` 대신 **`@RestController`**를 사용한 컨트롤러임.
* `@RestController`는 `@Controller` + `@ResponseBody`가 합쳐진 어노테이션으로, 해당 클래스의 **모든 메서드**가 View를 반환하지 않고 JSON/XML 등의 데이터 자체를 반환함.
* RESTful API 서버를 구현할 때 사용함.
