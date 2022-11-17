package com.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordDto {
    private String username;
    @NotBlank(message = "Будь ласка введіть старий пароль.")
    private String oldPassword;
    @NotBlank(message = "Будь ласка придумайте важкий пароль.")
    @Size(min = 8, max = 30, message = "Пароль повинен бути від 8 до 30 символів.")
    private String newPassword;
    @NotBlank(message = "Будь ласка придумайте важкий пароль.")
    @Size(min = 8, max = 30, message = "Пароль повинен бути від 8 до 30 символів.")
    private String matchingNewPassword;
}
