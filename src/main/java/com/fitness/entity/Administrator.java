package com.fitness.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;

}
