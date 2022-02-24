package com.fitness.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscription")
@Data
//Абонемент (подписка)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "tariff")
    String tariff;
    LocalDateTime dateNachalo;
    LocalDateTime End;

}
