package com.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @NotBlank(message = "Будь ласка придумайте свій нікнейм.")
    @Size(min = 2, max = 20, message = "Нікнейм повинен містити від 2 до 20 символів.")
    private String username;

    @NotBlank(message = "Будь ласка придумайте важкий пароль.")
    @Size(min = 8, max = 30, message = "Пароль повинен бути від 8 до 30 символів.")
    private String password;
    private String matchingPassword;

    @NotBlank(message = "Будь ласка введіть свою елктронну адресу.")
    @Email(message = "Елктронна адреса повинна мати таку структуру \"test@test.com\"")
    private String email;
}

