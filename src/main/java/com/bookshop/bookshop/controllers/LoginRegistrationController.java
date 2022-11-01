package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.UserDTO;
import com.bookshop.bookshop.service.PersonDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegistrationController {
    private PersonDetailsService userService;

    @GetMapping("/login-page")
    public String login(){
        return "login-page";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "login-page";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO userForm, Model model) {
        if (!userForm.getPassword().equals(userForm.getMatchingPassword())){
            model.addAttribute("passwordError", "Паролі не співпадають");
            return "login-page";
        }
        if (!userService.save(userForm)){
            return "login-page";
        }

        return "Success";
    }
}
