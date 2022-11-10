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
public class CommentDto {
    @NotBlank(message = "Неможливо відправити порожнє повідомлення. Будь ласка спробуйте ще раз.")
    @Size(min = 2, max = 500, message = "Повідомлення повинно містити від 2 до 500 символів.")
    private String massage;
}
