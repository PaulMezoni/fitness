package com.fitness.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "administrator")
public class Administrator extends BaseEntityId {

    String name;
    String login;
    String password;

}
