package com.hermes.msg.controller;

import com.hermes.msg.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	@Autowired
	private UsersService service;
	
	@GetMapping("/login")
	public String logIn() {
		return "login";
	}
	
	@GetMapping("/")
	public String homePage(Model modelo) {
		modelo.addAttribute("usuarios", service.listUsers());
		return "index";
	}
}
