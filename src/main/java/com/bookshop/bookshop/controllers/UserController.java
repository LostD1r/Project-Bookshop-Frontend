package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.PasswordDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import com.bookshop.bookshop.service.PersonDetailsService;
import com.bookshop.bookshop.service.RegistrationService;
import com.bookshop.bookshop.util.PasswordChangeValid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class UserController {
    private final PersonDetailsService personDetailsService;
    private final RegistrationService registrationService;
    private final PasswordChangeValid passwordChangeValid;

    public UserController(PersonDetailsService personDetailsService, RegistrationService registrationService,
                          PasswordChangeValid passwordChangeValid) {
        this.personDetailsService = personDetailsService;
        this.registrationService = registrationService;
        this.passwordChangeValid = passwordChangeValid;
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
        model.addAttribute("password", new PasswordDto());
        return "user-page-settings";
    }

    @PostMapping("/profile/settings/password")
    public String changePassword(@Valid @ModelAttribute("password") PasswordDto passwordDto, BindingResult bindingResult){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        passwordDto.setUsername(personDetails.getUsername());
        passwordChangeValid.validate(passwordDto, bindingResult);
        if(!passwordDto.getNewPassword().equals(passwordDto.getMatchingNewPassword())){
            bindingResult.rejectValue("newPassword", " ", "Паролі не співпадають. Спробуйте ще раз");
        }
        if(bindingResult.hasErrors()){
            return "user-page-settings";
        }
        registrationService.changePassword(personDetails.getUsername(), passwordDto);
        return "redirect:/profile";
    }
}
