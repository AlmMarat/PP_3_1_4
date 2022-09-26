package com.spring.security.pp_3_1_2_v2.controllers;

import com.spring.security.pp_3_1_2_v2.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String viewUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user/viewUser";
    }
}
