package com.bookshop.bookshop.util;

import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.models.User;
import com.bookshop.bookshop.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidation implements Validator {

    private final PersonDetailsService personDetailsService;

    public PersonValidation(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO person = (UserDTO) o;
        if(!personDetailsService.optionalFindByName(person.getUsername()).isEmpty()){
            errors.rejectValue("username", "", "Користувач з таким логіном уже існує. Будь ласка придумайте інший.");
        }
        if(!personDetailsService.findByEmail(person.getEmail()).isEmpty()){
            errors.rejectValue("email", "", "Ця електронна адреса вже зареєстрована.");
        }
    }
}
