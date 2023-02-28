package com.ebix.api.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Jenkins";
	}
}
