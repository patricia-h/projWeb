package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("home")
	public String homeBack() {
		return "home";
	}
	
	@RequestMapping("menu")
	public String menu() {
		return "menu";
	}
}
