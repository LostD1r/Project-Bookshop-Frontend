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
        model.addAttribute("user", new ChangeUserRoleDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        ChangeUserRoleDto changeUserRoleDto = (ChangeUserRoleDto) model.getAttribute("user");
        personDetailsService.updateUserRole(changeUserRoleDto, id);
        return "redirect:/admin/book";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        personDetailsService.delete(id);
        return "redirect:/admin";
    }
}
