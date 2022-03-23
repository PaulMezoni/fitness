package com.fitness.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
public class PersonDto {
    // Имя
    private String firstName;
    // Фамилия
    private String lastName;
    // email
    private String email;
    // Номер телефона
    private String phone;
    // Дата рождения
    private LocalDate birthdayDate;
}
