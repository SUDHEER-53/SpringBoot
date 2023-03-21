package com.cauthenticate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/home")
	public String home() {
		return ("welocme to security application");
	}
	@GetMapping("/balance")
	public String balance() {
		return ("your balance is 35000");
	}
	@GetMapping("/statement")
	public String stateMent() {
		
		String st ="statement geenarate and send to youremail ";
		return st;
	}
	@GetMapping("/loan")
	public String loan() {
		String str="your loan balance is 35000";
		return str;
	}
	@GetMapping("/contact")
	public String contact() {
		String con ="Thank you for contacting constomer care ";
		return con;
	}
}
