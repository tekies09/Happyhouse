package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Controller
@RequestMapping("/bookmark")
public class HappyHouseBookMarkController {
	
	@GetMapping("")
	public String bookmark() {
		return "bookmark";
	}
}
