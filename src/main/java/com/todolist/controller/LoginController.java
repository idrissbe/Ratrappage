package com.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("error", "user name ou password incorrecte");
		return "login";
	}

}
