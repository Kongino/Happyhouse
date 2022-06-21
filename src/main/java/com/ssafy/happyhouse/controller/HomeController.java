package com.ssafy.happyhouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/intro")
	public String intro() {
		return "intro";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/vueqna")
	public void vueqna() {
		
	}
	
	@GetMapping("/board/list")
	public String boardview() {
		return "notice";
	}
}
