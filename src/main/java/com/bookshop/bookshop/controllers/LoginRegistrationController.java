package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.security.UserDTO;
import com.bookshop.bookshop.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegistrationController {
    private final RegistrationService userService;

    public LoginRegistrationController(RegistrationService userService) {
        this.userService = userService;
    }

    @GetMapping("/login-page")
    public String login(Model model){
        model.addAttribute("userForm", new UserDTO());
        return "login-page";
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") UserDTO userForm, Model model) {
        if (!userForm.getPassword().equals(userForm.getMatchingPassword())){
            model.addAttribute("passwordError", "Паролі не співпадають");
            return "login-page";
        }
        if (!userService.save(userForm)){
            return "login-page";
        }

        return "redirect:/login-page";
    }
}
