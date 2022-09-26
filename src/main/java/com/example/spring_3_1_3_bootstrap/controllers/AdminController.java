package com.spring.security.pp_3_1_2_v2.controllers;

import com.spring.security.pp_3_1_2_v2.entities.User;
import com.spring.security.pp_3_1_2_v2.services.RoleService;
import com.spring.security.pp_3_1_2_v2.services.UserService;
import com.spring.security.pp_3_1_2_v2.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.allRoles());
        return "admin/newUser";
    }

    @PostMapping
    public String createUser(@RequestParam("roles") Long[] roleId,
                             @ModelAttribute("user") User user) {
        user.setRoles(roleService.findById(roleId));
        userService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("allRoles", roleService.allRoles());
        model.addAttribute("user", userService.findById(id));
        return "admin/updateUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@RequestParam("roles") Long[] roleId, @ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setRoles(roleService.findById(roleId));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "admin/show";
    }
}