package com.example.spring_3_1_3_bootstrap.controllers;

import com.example.spring_3_1_3_bootstrap.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping(value = "login")
    public String loginPage() {
        return "/login";
    }

    @GetMapping("/user")
    public String index(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "/user";
    }
}
