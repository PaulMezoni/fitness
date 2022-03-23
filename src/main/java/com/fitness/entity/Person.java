package com.fitness.entity;

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
public class Person extends BaseEntityId {

    // Имя
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    // Фамилия
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    // email
    @Column(name = "email", nullable = false)
    private String email;

    // Номер телефона
    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    // Дата рождения
    @Column(name = "birthday_date", nullable = false)
    private LocalDate birthdayDate;

    // Пользователь активен (true) или заблокирован (false)
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    // Лист абонементов
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    public List<Subscription> subscriptionList;

}
