package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class UserController {
    @GetMapping("/profile")
    public String showUserInfo(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        User user = personDetails.getUser();
        user.setBooks(new ArrayList<Book>());
        model.addAttribute("user", user);
        return "user-page-authorized";
    }

    @GetMapping("/profile/settings")
    public String settingProfile(Model model){
        return "user-page-settings";
    }
}
