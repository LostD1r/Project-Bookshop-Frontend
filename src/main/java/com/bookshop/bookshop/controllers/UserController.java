package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import com.bookshop.bookshop.service.PersonDetailsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class UserController {
    private final PersonDetailsService personDetailsService;

    public UserController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @GetMapping("/profile")
    public String showMyInfo(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        User user = personDetails.getUser();
        user.setBooks(new ArrayList<Book>());
        model.addAttribute("user", user);
        return "user-page-authorized";
    }

    @GetMapping("/profile/{id}")
    public String getUserInfo(@PathVariable("id") long id, Model model){
        User user = personDetailsService.findById(id);
        model.addAttribute("user", user);
        return "user-page";
    }

    @GetMapping("/profile/settings")
    public String settingProfile(Model model){
        return "user-page-settings";
    }
}
