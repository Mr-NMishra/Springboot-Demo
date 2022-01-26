package com.mishra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mishra.entities.User;

@Controller
public class BaseController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("signup")
	public String singup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping("login")
	public String login() {
		return "login";
	}
}
