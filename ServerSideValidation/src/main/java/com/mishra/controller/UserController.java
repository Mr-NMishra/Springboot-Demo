package com.mishra.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mishra.dao.UserRepository;
import com.mishra.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index")
	public String dashBoard(Model model, Principal principal) {
		String email= principal.getName();
		 User user= userRepository.getUserByUserName(email);
		 model.addAttribute("user", user);
		return "User_DashBoard";
	}
}
