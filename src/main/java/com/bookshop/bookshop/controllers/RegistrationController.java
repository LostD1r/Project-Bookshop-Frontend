package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "login-page";
    }

    @PostMapping("/registration")
    public String addUser(UserDTO userForm, Model model) {
        if (!userForm.getPassword().equals(userForm.getMatchingPassword())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "login-page";
        }
        if (!userService.save(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "login-page";
        }

        return "redirect:/";
    }
}
