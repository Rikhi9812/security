package com.example.securityJdbc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCont {
	
	

	@GetMapping("/")
	public String home() {
		return "(<h1>hello home</h1>)";
	}
	
	@GetMapping("/user")
	public String user() {
		return "(<h1>hello user</h1>)";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "(<h1>hello admin</h1>)";
	}

}
