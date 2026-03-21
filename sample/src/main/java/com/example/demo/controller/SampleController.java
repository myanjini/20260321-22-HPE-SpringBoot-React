package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!!!";
	}
	
	@PostMapping("/post")
	public String post() {
		return "Post Called!";
	}

	@PutMapping("/put")
	public String put() {
		return "Put Called!";
	}

	@DeleteMapping("/delete")
	public String delte() {
		return "Delete Called!";
	}
}
