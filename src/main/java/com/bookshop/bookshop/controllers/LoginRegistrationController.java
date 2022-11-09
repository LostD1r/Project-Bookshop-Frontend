package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.service.RegistrationService;
import com.bookshop.bookshop.util.PersonValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginRegistrationController {
    private final RegistrationService registrationService;
    private final PersonValidation personValidation;

    public LoginRegistrationController(RegistrationService registrationService, PersonValidation personValidation) {
        this.registrationService = registrationService;
        this.personValidation = personValidation;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userForm", new UserDTO());
        return "login-page";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new UserDTO());
        return "registration-page";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult, Model model) {
        personValidation.validate(userForm, bindingResult);
        if (!userForm.getPassword().equals(userForm.getMatchingPassword())) {
            bindingResult.rejectValue("password", "", "Паролі не співпадають. Перевірте будь ласка правильність їх написання.");
        }
        if (bindingResult.hasErrors()){
            return "registration-page";
        }
        if (!registrationService.save(userForm)){
            return "redirect:/registration";
        }
        return "redirect:/login";
    }
}
