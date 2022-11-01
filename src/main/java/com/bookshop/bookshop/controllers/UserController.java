package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/profile")
    public String showUserInfo(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        User user = personDetails.getUser();
        model.addAttribute("user", user);
        return "user-page";
    }
}
