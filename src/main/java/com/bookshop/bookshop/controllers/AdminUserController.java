package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.ChangeUserRoleDto;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.service.PersonDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    private final PersonDetailsService personDetailsService;


    public AdminUserController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        User user = personDetailsService.findById(id);
        ChangeUserRoleDto userDto = new ChangeUserRoleDto(user.getRole().name());
        model.addAttribute("id", id);
        model.addAttribute("user", userDto);
        return "admin/change-users-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("user") ChangeUserRoleDto userDto){
        personDetailsService.updateUserRole(userDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        personDetailsService.delete(id);
        return "redirect:/admin";
    }
}
