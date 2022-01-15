package com.mishra.cltr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

	@RequestMapping("Home")
	public String home() {
		return "Home";
	}
}
