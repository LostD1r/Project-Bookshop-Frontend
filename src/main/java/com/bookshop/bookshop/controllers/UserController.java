package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.PasswordDto;
import com.bookshop.bookshop.dto.PersonDataChangeDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.security.PersonDetails;
import com.bookshop.bookshop.service.PersonDetailsService;
import com.bookshop.bookshop.service.RegistrationService;
import com.bookshop.bookshop.util.PasswordChangeValid;
import com.bookshop.bookshop.util.PersonDataChangeValid;
import org.mapstruct.control.MappingControl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final PersonDetailsService personDetailsService;
    private final RegistrationService registrationService;
    private final PasswordChangeValid passwordChangeValid;
    private final PersonDataChangeValid personDataChangeValid;

    public UserController(PersonDetailsService personDetailsService, RegistrationService registrationService,
                          PasswordChangeValid passwordChangeValid, PersonDataChangeValid personDataChangeValid) {
        this.personDetailsService = personDetailsService;
        this.registrationService = registrationService;
        this.passwordChangeValid = passwordChangeValid;
        this.personDataChangeValid = personDataChangeValid;
    }

    @GetMapping("/profile")
    public String showMyInfo(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        User user = personDetails.getUser();
        List<Book> books = user.getBooks();
        model.addAttribute("books", books);
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        User user = personDetails.getUser();
        PersonDataChangeDto personDataChangeDto = PersonDataChangeDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .about(user.getAbout())
                .build();
        model.addAttribute("data", personDataChangeDto);
        return "user-page-settings";
    }

    @PatchMapping ("/profile/settings/password")
    public String changePassword(@Valid @ModelAttribute("password") PasswordDto passwordDto, BindingResult bindingResult, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        passwordDto.setUsername(personDetails.getUsername());
        passwordChangeValid.validate(passwordDto, bindingResult);
        User user = personDetails.getUser();
        PersonDataChangeDto personDataChangeDto = PersonDataChangeDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .about(user.getAbout())
                .build();

        if(bindingResult.hasErrors()){
            model.addAttribute("data", personDataChangeDto);
            return "user-page-settings";
        }
        registrationService.changePassword(personDetails.getUsername(), passwordDto);
        return "redirect:/profile";
    }

    @PatchMapping("/profile/settings/data")
    public String changeData(@Valid @ModelAttribute("data") PersonDataChangeDto personDataChangeDto, BindingResult bindingResult, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        personDataChangeDto.setOldName(personDetails.getUsername());
        personDataChangeValid.validate(personDataChangeDto, bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("password", new PasswordDto());
            return "user-page-settings";
        }
        personDetailsService.changeUserData(personDetails.getUsername(), personDataChangeDto);
        return "redirect:/profile";
    }
}
