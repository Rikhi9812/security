package com.example.security.securitycontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCont {
	
	@GetMapping("/home")
	public String home() {
		return "(<h1>hello user</h1>)";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "(<h1>hello admin</h1>)";
	}


}
