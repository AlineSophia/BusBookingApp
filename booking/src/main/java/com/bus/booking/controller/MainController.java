package com.bus.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/bus";
	}

	
}
