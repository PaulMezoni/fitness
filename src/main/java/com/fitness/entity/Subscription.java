package com.fitness.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
//Абонемент (подписка)
public class Subscription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameTariff;
    Integer countOfVisit;
    Integer restOfVisit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
