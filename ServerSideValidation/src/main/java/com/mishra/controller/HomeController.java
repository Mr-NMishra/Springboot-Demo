package com.mishra.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mishra.dao.UserRepository;
import com.mishra.entities.User;
import com.mishra.helper.Message;

@Controller
public class HomeController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	@PostMapping("do-register")
	public String registerUser(@Valid @ModelAttribute("user") User user,
			@RequestParam(value = "condition", defaultValue = "false") boolean aggrement, Model model,
			BindingResult bindingResult, HttpSession session) {

		try {
			if (!aggrement) {
				System.out.println("Terms and condition not accepted");
				throw new Exception("Terms and condition not accepted");
			}

			if (bindingResult.hasErrors()) {
				System.out.println(bindingResult.getErrorCount());
				model.addAttribute("user", user);
				return "login";
			}
			user.setRole("ROLE_USER");
			user.setEnable(true);
			user.setImageUrl("Defaut-Image.png");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User result = repository.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("saved successfull", "alert-success"));
			return "index";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Message("Something-went wrong", "alert-error"));
			return "login";
		}

	}
}
