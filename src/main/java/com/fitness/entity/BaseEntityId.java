package com.fitness.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Базовая сущность для ID
 */
// стоит ли делать общий класс ID для всех сущностей ?
@MappedSuperclass
@Getter
@Setter
public class BaseEntityId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

}
