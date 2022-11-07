package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegistrationController {
    private final RegistrationService registrationService;

    public LoginRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/login-page")
    public String login(Model model){
        model.addAttribute("userForm", new UserDTO());
        return "login-page";
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") UserDTO userForm, Model model) {
        System.out.println(755);
        if (!userForm.getPassword().equals(userForm.getMatchingPassword())){
            model.addAttribute("passwordError", "Паролі не співпадають");
            return "redirect:/login-page";
        }
        System.out.println(655);
        if (!registrationService.save(userForm)){
            return "redirect:/login-page";
        }
        System.out.println(555);
        return "login-page";
    }
}
