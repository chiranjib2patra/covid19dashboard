package com.assignments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/login")
	public String login() {

		return "login";
	}

	@GetMapping("/register")
	public String register() {

		return "register";
	}
	
	@GetMapping("/tnc")
	public String terms_conditions() {

		return "terms_conditions";
	}
}
