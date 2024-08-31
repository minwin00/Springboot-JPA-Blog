package com.cos.blog.test;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest : ";

	@GetMapping("/http/lombok")
	public String lombokTest() {
//		Member m1 = new Member(1, "ssar","1234","email");
		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG+"getter : "+m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"setter : "+m.getUsername());
		return "lombok test 완료";
	}
	
	
	//인터넷 브라우저 요청은 get밖에 할 수 없다.
	//http://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		
		
		return "get 요청: "+m.getId()+", "+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/post
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청: "+m.getId()+", "+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/put
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청: "+m.getId()+", "+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/delete
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청: " +m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
}
