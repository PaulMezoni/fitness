package com.fitness.entity;

import com.fitness.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Логин
    @Column(name = "user_name", nullable = false, unique = true, length = 50)
    private String username;
    // Имя
    @Column(name = "first_name", length = 50)
    private String firstName;
    // Фамилия
    @Column(name = "last_name", length = 50)
    private String lastName;
    // email
    @Column(name = "email")
    private String email;

    // Номер телефона
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    // Дата рождения
    @Column(name = "birthday_date")
    private LocalDate birthdayDate;

    // Пол
    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    // Пользователь активен (true) или заблокирован (false)
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    // Лист абонементов
    @OneToMany
    public List<Subscription> subscriptionList;

}
