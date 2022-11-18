package com.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDataChangeDto {
    private String oldName;
    @NotBlank(message = "Будь ласка придумайте свій нікнейм.")
    @Size(min = 2, max = 20, message = "Нікнейм повинен містити від 2 до 20 символів.")
    private String name;
    @NotBlank(message = "Будь ласка введіть свою елктронну адресу.")
    @Email(message = "Елктронна адреса повинна мати таку структуру \"test@test.com\"")
    private String email;
    @Size(max = 500, message = "Пункт про себе може бути максимально 500 символів.")
    private String about;
}
