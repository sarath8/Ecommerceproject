package com.niit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeContoller {
	@RequestMapping("/")
	public  String homePage(Model model) {
		return "home";
		
	}
}


