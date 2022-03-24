package com.hermes.msg.controller;

import com.hermes.msg.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hermes.msg.controller.dto.UsersRegisterDTO;

@Controller
@RequestMapping("/register")
public class RegisterUsersController {

    private UsersService usersService;

    public RegisterUsersController(UsersService usersService) {
        super();
        this.usersService = usersService;
    }

    @ModelAttribute("users")
    public UsersRegisterDTO returnNewUserRegisterDTO() {
        return new UsersRegisterDTO();
    }

    @GetMapping
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("users") UsersRegisterDTO registerDTO) {
        usersService.save(registerDTO);
        return "redirect:/register?success";
    }
}
